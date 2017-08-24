using Microsoft.VisualStudio.TestTools.UnitTesting;
using SistemaVendas;
using NSubstitute;
using System.Collections.Generic;


namespace TesteVendas
{
    [TestClass]
    public class TesteCalculoRoyalties
    {
        IRepositorioVendas repository ;

        [TestInitialize]
        public void inicializaMocks()
        {
            repository = Substitute.For<IRepositorioVendas>();
        }

        [TestMethod]
        public void CalcularRoyaltiesQuandoOMesNaoTemVenda()
        {
            int mes = 2;
            int ano = 2017;
            
            decimal totalRoyalties = 0;
            repository.GetVendas(mes, ano).Returns(new List<decimal>());

            var calculoRoyalties = new CalculoRoyalties(repository);

            decimal resultado = calculoRoyalties.Calcular(mes, ano);

            Assert.AreEqual(totalRoyalties, resultado);
        }

        [TestMethod]
        public void CalcularRoyaltiesQuandoOMesTemVenda()
        {
            int mes = 3;
            int ano = 2017;

            decimal totalRoyalties = 1900;
            
            repository.GetVendas(mes, ano).Returns(new List<decimal>() { 10000 });

            var calculoRoyalties = new CalculoRoyalties(repository);            

            decimal resultado = calculoRoyalties.Calcular(mes, ano);

            Assert.AreEqual(totalRoyalties, resultado);
        }
        [TestMethod]
        public void CalcularRoyaltiesQuandoOFaturamentoMaiorQue10000()
        {
            int mes = 4;
            int ano = 2017;

            decimal totalRoyalties = 1880.28m;

            
            IRepositorioVendas repository = Substitute.For<IRepositorioVendas>();
            repository.GetVendas(mes, ano).Returns(new List<decimal>() { 10001.50m });

            var calculoRoyalties = new CalculoRoyalties(repository);

            decimal resultado = calculoRoyalties.Calcular(mes, ano);

            Assert.AreEqual(totalRoyalties, resultado);
        }

        [TestMethod]
        public void CalcularRoyaltiesQuandoOMesInvalido()
        {
            int mes = 15;
            int ano = 2017;
            var calculoRoyalties = new CalculoRoyalties();
            try
            {
                 calculoRoyalties.Calcular(mes, ano);
                 Assert.Fail();
            }
            catch (System.Exception ex)
            {
                Assert.AreEqual("Mes Invalido", ex.Message);
            }
        }
    }
}

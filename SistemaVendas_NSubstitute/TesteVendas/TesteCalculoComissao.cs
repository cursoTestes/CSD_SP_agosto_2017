using Microsoft.VisualStudio.TestTools.UnitTesting;
using SistemaVendas;

namespace TesteVendas
{
    [TestClass]
    public class TesteCalculoComissao
    {
       [TestMethod]
        public void CalcularComissaoVendaMenorQueDezMilQuandoValorDeVendaForDecimal()
        {
            decimal valorVenda = 1000.50m;
            decimal retornoEsperado = 50.025m;

            decimal retornoComissao = CalculoComissao.calcular(valorVenda);

            Assert.AreEqual(retornoEsperado, retornoComissao);
        }

       [TestMethod]
       public void CalcularComissaoVendaIgualDezMil()
       {
           decimal valorVenda = 10000m;
           decimal retornoEsperado = 500m;

           decimal retornoComissao = CalculoComissao.calcular(valorVenda);

           Assert.AreEqual(retornoEsperado, retornoComissao);
       }

        [TestMethod]
       public void calcularComissaoVendaMaiorQueDezMil()
       {
           decimal valorVenda = 10000.50m;
           decimal retornoEsperado = 600.03m;

           decimal retornoComissao = CalculoComissao.calcular(valorVenda);

           Assert.AreEqual(retornoEsperado, retornoComissao);  
       }
    }
}

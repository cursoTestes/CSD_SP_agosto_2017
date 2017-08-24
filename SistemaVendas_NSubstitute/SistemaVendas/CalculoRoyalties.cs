using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SistemaVendas
{
    public class CalculoRoyalties
    {
        private IRepositorioVendas repositoryVendas;
        public CalculoRoyalties()
        {

        }
        public CalculoRoyalties(IRepositorioVendas repositoryVendas)
        {
            this.repositoryVendas = repositoryVendas;
        }

        public decimal Calcular(int mes, int ano)
        {
            decimal valorLiquido = 0;
            
            if (mes > 12 || mes < 1)
                throw new Exception("Mes Invalido");

            List<decimal> vendas = repositoryVendas.GetVendas(mes, ano);
            if (vendas.Count == 0)
                return 0;
            
            foreach (var item in vendas)
            {
                decimal valorComissao = CalculoComissao.calcular(item);
                valorLiquido += item - valorComissao;
            }
            return valorLiquido * 0.2m;
        }
    }
}

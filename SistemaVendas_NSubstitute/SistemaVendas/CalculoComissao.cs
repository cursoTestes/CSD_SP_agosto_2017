using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SistemaVendas
{
    public static class CalculoComissao
    {
        public static decimal calcular(decimal valorProduto)
        {
            var retorno = 0m;
            if (valorProduto <= 10000.00m)
                retorno = valorProduto * 0.05m;
            else
                retorno = valorProduto * 0.06m;

              return retorno; 
        }
    }
}

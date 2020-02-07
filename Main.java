// Este cógigo foi feito por Gustavo Almeida e testado no NetBeans 8.0.2
// O código foi criado para o cálculo do descontos de imposto de renda retido na fonte.
// A class Salario é utilizada para o cálculo dos desconto.
// Além disso foi necessãrio o uso de bibliotecas para arendondar valores decimais,
// como math.RoundingMode e text.DecimalFormat para que os descontos e o salário final não
// tenha mais casas decimais que a moeda utilizada 

package teste;

import java.util.*;
public class Main {

    public static void main(String[] args) {
        float salario;
        int dependente;
        Calculo_do_imposto valor = new Calculo_do_imposto();
        Scanner input = new Scanner (System.in);  
        
        System.out.println("digite o seu salário");
        
        valor.salario = input.nextFloat();
        
        System.out.println("Digite a quantidade de dependenetes");
        
        valor.dependente = input.nextInt();
        
        
        valor.impostoINSS();
        valor.impostoIRPF();
        valor.desconto_final();
        valor.salario_final();
        
        
    }
    
}
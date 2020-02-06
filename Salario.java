package teste;
 // class utilizada para calcular descontos no salário
 
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Salario {
    public float salario;
    public int dependente;
    public double inss;
    public double irpf;
    public double desconto_final;
    public double desconto_dependente;

     private static String arredondar(double valor) {
   DecimalFormat df = new DecimalFormat("0.00");
   df.setRoundingMode(RoundingMode.HALF_UP);
   return df.format(valor);
    }
    
    void impostoINSS(){
        // se salário até 1751,81 alicota de 8%
        if (this.salario < 1751.81) {
        this.inss = this.salario * 0.08;
        }
        // se salário de 1751,82 até 2919,72 9%
        if ((this.salario > 1751.82) && (this.salario < 2919.72)) {
        this.inss = this.salario * 0.09;
        }
        // se salário maior que 2919,73 e menor que 5839,45
        if ((this.salario > 2919.73 ) && (this.salario <= 5839.45)) {
        this.inss = this.salario * 0.11;
        }
        // se salário maior que 5839,45 então valor máximo de inss é 642,34 
        if(this.salario>5839.45) {
          
        this.inss = 642.34;    
        
        }
        // imprime o valor do imposto do inss arredondado                            
        System.out.println("imposto_inss = R$ " + arredondar(this.inss));
        }
    
    void impostoIRPF(){
        
        // se salário menor 1903,98 alícota é 0
         if (this.salario < 1903.98) {
        this.irpf = 0;
        }
        // se salário de 1903,99 até 2826,65 alícota é 7,5% de irpf
        if ((this.salario > 1903.99) && (this.salario < 2826.65)) {
        this.irpf = this.salario * 0.075;
        }
        // se salário de 2826,66 até 3751,05 alícota é 15% de irpf
        if ((this.salario > 2826.66  ) && (this.salario <= 3751.05)) {
        this.irpf = this.salario * 0.15;
        }
        // se salário de 3751,06 até 4664,68 alícota é 22,5% de irpf
        if ((this.salario > 3751.06  ) && (this.salario <= 4664.68)) {
        this.irpf = this.salario * 0.225;
        }
        // se salário maior que 4664,68 alicota de 27,5%
        if(this.salario>4664.68) {
        this.irpf = this.salario * 0.275;    
        }
        
        desconto_dependente();
        // o cálculo é dado pelo iprf menos o desconto de ependente

        this.irpf = this.irpf - this.desconto_dependente;
        
        if (this.irpf < 0){
            this.irpf = 0;
            System.out.println("imposto_irpf = R$ " + arredondar(this.irpf));            
        }
        
        else {
        System.out.println("imposto_irpf = R$ " + arredondar(this.irpf));
        
        }
        
        }
    
    void desconto_dependente(){
        // o desconto de dependente é dado pelo numero de dependentes
        // vezes do desconto do valor multiplicado por 189,59
        this.desconto_dependente = this.dependente * 189.59;
        
    }
    void desconto_final(){
        // calculo do desconto final
        this.desconto_final = this.inss + this.irpf;
        System.out.println("desconto_total = R$ " + arredondar(this.desconto_final));
    }
    
    void salario_final(){
        // cáculo do salário final,  valor final arredondadao
        System.out.println("salario_final = R$" + arredondar((this.salario - this.inss - this.irpf) ));
        
        }
    
}
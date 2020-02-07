// class utilizada para calcular descontos no salário
package teste;
 
// bibliotecas de arredondamento de valores decimais 
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Calculo_do_imposto {
    public float salario;
    public int dependente;
    private double inss;
    private double irpf;
    private double desconto_final;
    private double desconto_dependente;

     private static String arredondar(double valor) {
   DecimalFormat df = new DecimalFormat("0.00");
   df.setRoundingMode(RoundingMode.HALF_UP);
   return df.format(valor);
    }
    

    
    void impostoIRPF(){
        
        // se salário menor 1903,98 alícota é 0
         if (this.salario < 1903.98) {
        setIrpf(0);
        }
        // se salário de 1903,99 até 2826,65 alícota é 7,5% de irpf
        if ((this.salario > 1903.99) && (this.salario < 2826.65)) {
        setIrpf(this.salario * 0.075);
        }
        // se salário de 2826,66 até 3751,05 alícota é 15% de irpf
        if ((this.salario > 2826.66  ) && (this.salario <= 3751.05)) {
        setIrpf(this.salario * 0.15);
        }
        // se salário de 3751,06 até 4664,68 alícota é 22,5% de irpf
        if ((this.salario > 3751.06  ) && (this.salario <= 4664.68)) {
        setIrpf(this.salario * 0.225);
        }
        // se salário maior que 4664,68 alicota de 27,5%
        if(this.salario>4664.68) {
        setIrpf(this.salario * 0.275);    
        }
        
        // o cálculo é dado pelo iprf menos o desconto de ependente
        desconto_dependente();
        
        setIrpf(this.irpf - this.desconto_dependente);
        
        if (this.irpf < 0){
            setIrpf(0);
            System.out.println("imposto_irpf = R$ " + arredondar(this.irpf));            
        }
        
        else {
        System.out.println("imposto_irpf = R$ " + arredondar(this.irpf));
        
        }
        
        }
    
    void desconto_dependente(){
        // o desconto de dependente é dado pelo numero de dependentes
        // vezes do desconto do valor multiplicado por 189,59
        setDesconto_dependente((this.dependente * 189.59));
        
    }
    void desconto_final(){
        // calculo do desconto final
        setDesconto_final(this.inss + this.irpf);
        System.out.println("desconto_total = R$ " + arredondar(this.desconto_final));
    }
    
    void salario_final(){
        // cáculo do salário final,  valor final arredondadao
        System.out.println("salario_final = R$" + arredondar((this.salario - this.inss - this.irpf )));
        
        }

         

    public void setInss(double inss) {
        this.inss = inss;
    }


    public void setIrpf(double irpf) {
        this.irpf = irpf;
    }


    public void setDesconto_final(double desconto_final) {
        this.desconto_final = desconto_final;
    }



    public void setDesconto_dependente(double desconto_dependente) {
        this.desconto_dependente = desconto_dependente;
    }
    
    
}
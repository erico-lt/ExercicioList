public class Funcionario{
    private String name;
    private int id;
    private double salario;

    public Funcionario(){        
    }

    public  Funcionario(String name, int id, double salario){
        this.setName(name);
        this.setId(id);
        this.setSalario(salario);
    }

    public void aumentarSalario(double porcentagem){
        this.setSalario(this.getSalario() + (this.getSalario() * porcentagem / 100));
    }
     
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalario() {
        return salario;
    }

    private void setSalario(double salario) {
        this.salario = salario;
    }

    public String toString(){
       return this.getId() + ", " + this.getName() + ", " + String.format("%.2f", this.getSalario());
    }

}
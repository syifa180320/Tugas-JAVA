public class SavingsAccount extends BankAccount {
    private double interestRate; // bunga tahunan
    private int withdrawalCount; // jumlah tarik
   
    public SavingsAccount(String accountNumber, String ownerName, double initialBalance, double interestRate) {
        super(accountNumber, ownerName, initialBalance);
        this.interestRate = interestRate;
        this.withdrawalCount = 0;
        System.out.println("Akun Tabungan " + ownerName + " dibuat dengan bunga " + (interestRate * 100) + "% per bulan, dengan bunga tahunan 12%. ");
    }
   
    //Override
    public void withdraw(double amount) {
        if (withdrawalCount >= 3) { // max batas penarikan salam satu bulan
            System.out.println(" Gagal tarik : Batas penarikan bulanan tercapai!");
            return;
        }
        super.withdraw(amount);
        withdrawalCount++; // tambah jumlah penarikan
        System.out.println("jumlah tarik pada bulan ini: " + withdrawalCount + " kali");
    }
    public void applyAnnualInterest(){ // tambah bunga tahunan
        double interest = getBalance() * interestRate;
        if (interest > 0) { // bunga lebih besar dari 0
            deposit(interest); // menambahkan bunga ke saldo akun
            System.out.println("Bunga bulan ini sebesar Rp" + df.format((int)interest) + " telah ditambahkan.");
        }else{
            System.out.println("bunga terlalu kecil untuk ditambahkan.");
        }  
    }
   
}
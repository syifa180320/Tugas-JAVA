public class CheckingAccount extends BankAccount { // rekening giro
    private double monthlyFee; // simpan biaya bulanan
   
    // membuat rekening giro dengan nomor akun, nama, saldo awal dan biaya bulanan
    public CheckingAccount(String accountNumber, String ownerName, double initialBalance, double monthlyFee) {
        super(accountNumber, ownerName, initialBalance); // konstruktor untuk memanggil bankaccount(super class)
        this.monthlyFee = monthlyFee; //mengambil biaya bulanan dan disimpan di atribut 
        System.out.println("Akun Giro " + ownerName + " dibuat dengan biaya Rp " + df.format((int) monthlyFee) + " per bulan.");
    }
    public void deductMonthlyFee(){ // potongan biaya bulanan
        if (getBalance() < monthlyFee){ // cek apakah saldo kurang dari biaya bulanan
            System.out.println("gagal tarik : uang tidak cukup untuk bayat biaya Rp" + df.format((int) monthlyFee) + "!");
            return; // hentikan proses jika saldo kurang
    }
        withdraw(monthlyFee); // mengurangi biaya bulanan dari saldo
        System.out.println("biaya bulanan Rp" + df.format((int) monthlyFee) + " sudah dipotong.");
    }
}
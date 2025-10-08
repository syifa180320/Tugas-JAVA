public class Main { // kelas untuk menjalankan program / utuk tampilan output
    public static void main(String[] args) {
        try { // menjalankan kode dan mendeteksi jika ada kesalahan
            System.out.println("=== Membuat Akun ===");
            //membuat objek untuk akun andi dan budi
            BankAccount andi = new BankAccount("123","Andi",1800000);
            BankAccount budi = new BankAccount("456","Budi",1500000);
            System.out.println(); 
           
            // transaksi deposit ( setor uang )
            System.out.println("=== Deposit ===");
            andi.deposit(300000); // setor uang ke akun andi
            andi.deposit(-100); //  setor uang dengan jumlah negatif tetapi gagal karena deposit tidak boleh negatif
            System.out.println();
           
            //transakso withdraw ( tarik uang )
            System.out.println("=== Withdraw===");
            andi.withdraw(100000);
            andi.withdraw(3000000); // tarik uang andi tetapi gagal karena melebihi saldo
            System.out.println();
           
            System.out.println("=== Ubah Nama ===");
            andi.ubahNama("Andi Hidayat");
            andi.ubahNama(""); // jika nama baru kosong maka tidak dapat berubah
            System.out.println();
           
            System.out.println("=== Berhasil Transaksi ===");
            andi.transfer(budi, 500000);
            System.out.println("Saldo Andi Sekarang: Rp" + BankAccount.df.format((int)andi.getBalance())); 
            System.out.println("Saldo Budi Sekarang: Rp" + BankAccount.df.format((int)budi.getBalance()));
            System.out.println();
           
            System.out.println("=== Riwayat Transaksi===");
            System.out.println("\nRiwayat Transaksi Andi: ");
            for (String transaksi : andi.lihatRiwayat()){
                System.out.println("-" + transaksi);
               
            }
            System.out.println();
            System.out.println("Riwayat Transaksi Budi: ");
            for (String transaksi : budi.lihatRiwayat()){ // 'loop' perulangan yang mengambil setiap riwayat di setiap transaksi dalam bentuk string
                System.out.println("-" + transaksi);
            }
        } catch (IllegalArgumentException e) { // menangani kesalahan yang terjadi di try dengan cara mencetak pesan
            System.out.println("Error: " + e.getMessage());
        }
    }
}

   


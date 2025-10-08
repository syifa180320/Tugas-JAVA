import java.util.ArrayList; // membawa kelas array list ke program, agar bisa menambahkan daftar list yang untuk menyimpan riwayat transaksi
import java.text.DecimalFormat;
public class BankAccount { // kelas untuk mengelola akun bank
    private String accountNumber; // menyimpan nomor akun nasabah
    private String ownerName; // menyimpan nama pemilik nasabah
    private double Balance; // menyimpan jumlah saldo setiap akun
    private ArrayList<String> riwayat; // menyimpan daftar riwayat transaksi (setor, tarik, transfer)
    
    // df = memformat angka, decimal, pemisah ribuan
    //',' pemisah ribuan yang akan ditambahkan setiap digit dari kanan ke kiri
    static final DecimalFormat df = new DecimalFormat("#,###");
    // membuak objek akun bank baru, mengatur validasi awal, dan mengatur awal data akun
    public BankAccount(String accountNumber, String ownerName, double initialBalance ) { //parameter = data yang diterima dari luar / input data
    // memvalidasi apakah nomor, nama akun kosong dan saldo awal negatif.
        if (accountNumber.isEmpty()) //memastikan data yang dimasukkan tidak kosong
            throw new IllegalArgumentException("Nomor Akun tidak boleh kosong!"); // menghentikan eksekusi dan memberi tahu program, ada argumen yang tidak valid
        if (ownerName.isEmpty())
            throw new IllegalArgumentException("Nama Nasabah tidak boleh kosong!");
        if (initialBalance < 0 )
            throw new IllegalArgumentException("Saldo Awal tidak boleh Negatif!");
       
        // 'this' digunakan untuk membedakan atribut kelas dengan parameter
        // 'this'kata kunci yang merujuk pada atribut
        this.accountNumber = accountNumber; // mengambil nilai "123" dari parameter dan menyimpan nya ke atribut
        this.ownerName = ownerName;
        this.Balance = initialBalance;
        this.riwayat = new ArrayList<>();
        // mencetak pembuatan akun
        System.out.println(" Akun " + ownerName + " dengan nomor " + accountNumber + " Berhasil dibuat dengan saldo awal Rp" + df.format((int)initialBalance));
    }
    
    public void deposit(double amount){ // menambah saldo akun.
        if (ownerName.isEmpty()) { 
            System.out.println("Gagal Deposit: Nama Nasabah tidak boleh kosong!");
            return; // menghentikan eksekusi yang sedang berjalan
        }
        if (amount <= 0) { //jika jumlah negatif atau nol, maka tampilan akan error
            System.out.println("Gagal Deposit: jumlah Deposit tidak boleh Negatif!");
            return;
        }
        double saldoLama = Balance;// simpan saldo lama            
        Balance += amount; // tambah jumlah ke saldo
        riwayat.add(" Deposit: Rp" + df.format((int)amount)); //tambah riwayat transaksi andi
        //mencetak detail transaksi
        System.out.println("Transaksi Deposit: ");
        System.out.println(" - Saldo Sebelum Deposit: Rp" + df.format((int)saldoLama));
        System.out.println(" - Jumlah Deposit: Rp" + df.format((int)amount));
        System.out.println(" - Saldo Setelah Deposit: Rp" + df.format((int)Balance));
        System.out.println( ownerName + " telah berhasil Deposit");
    }
    public void withdraw(double amount){ //tarik saldo
        if (ownerName.isEmpty()) { //validasi  nama kosong
            System.out.println("Gagal Tarik: Nama Nasabah tidak boleh kosong!");
            return;
        }
        if (amount <= 0) {
            System.out.println("Gagal Tarik: jumlah Penarikan tidak boleh negatif!");
            return;
        }
        if (amount > Balance) { // validasi jika jumlah melebihi saldo
            System.out.println("Gagal Tarik: saldo tidak cukup!");
            return;
        }
        double saldoLama = Balance; //simpan saldo lama
        Balance -= amount; // kurangi saldo
        riwayat.add(" Penarikan: Rp" + df.format((int)amount)); //tambah riwayat transaksi andi
        System.out.println("Transaksi Withdraw:");
        System.out.println(" - Saldo Sebelum Penarikan: Rp" + df.format((int)saldoLama));
        System.out.println(" - Jumlah Penarikan: Rp" + df.format((int)amount));
        System.out.println(" - Saldo Setelah Penarikan: Rp" + df.format((int)Balance));
        System.out.println( "Saldo " + ownerName + " telah berhasil Ditarik");
    }
    public void ubahNama(String namaBaru) {
        if (namaBaru.isEmpty()){
            System.out.println("Gagal Ganti Nama: Nama baru tidak boleh kosong!");
            return;
        }
        this.ownerName = namaBaru;
        System.out.println("Nama akun telah berhasil di ubah menjadi " + namaBaru);
    }
    public void transfer(BankAccount tujuan, double amount) {
        if (ownerName.isEmpty() || tujuan.ownerName.isEmpty()) { //validasi nama pengirim ke nama tujuan
            System.out.println("Gagal Transfer: nama tidak boleh kosong!");
            return;
        }
        if (amount <= 0) { 
            System.out.println("Gagal Transfer: jumlah tidak boleh negatif!");
            return;
        }
        if (amount > Balance) { //validasi jika jumlah melebihi saldo
            System.out.println("Gagal Transfer: saldo tidak cukup!");
            return;
        }
        //proses transfer
        Balance -= amount; //mengurangi jumlah saldo saat transfer
        tujuan.Balance += amount; //tambah saldo tujuan
        riwayat.add(" Transfer ke " + tujuan.ownerName + ": Rp" + df.format((int)amount)); //tambah riwayat transaksi andi
        tujuan.riwayat.add(" Telah diterima dari " + ownerName + ": Rp" + df.format((int)amount)); //tambah riwayat transaksi budi
        //mencetak berhasil transfer
        System.out.println("Berhasil transfer: Rp" + df.format((int)amount) + " dari " + ownerName + "( Akun " + accountNumber + " ) ke " + tujuan.ownerName + "( Akun " + tujuan.accountNumber + " ).");
    }
    // Getter untuk saldo
    public double getBalance() { // untuk menampilkan saldo di main
        return Balance; //mengembalikan saldo ( kembali dipanggil di main )               
    }
    // Getter untuk riwayat transaksi
    public ArrayList<String> lihatRiwayat() {
        return riwayat; //mengembalikan riwayat
    }
}
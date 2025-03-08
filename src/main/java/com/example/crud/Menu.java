package com.example.crud;

import java.util.Scanner;

public class Menu {

    public static void menu() {
        System.out.println();
        System.out.println("================");
        System.out.println("|Pilih menu|");
        System.out.println("----------------");
        System.out.println("|  [C] : Create  |");
        System.out.println("|  [R] : Read    |");
        System.out.println("|  [U] : Update  |");
        System.out.println("|  [D] : Delete  |");
        System.out.println("|  [X] : Exit    |");
        System.out.println("================");

    }

    public static void main(String[] args) {
        Database db = new Database();
        System.out.println("Wellcome");
        while (true) {
            menu();
            Scanner sc = new Scanner(System.in);
            System.out.println("pilih:  ");
            String pilihan = sc.nextLine();
            pilihan = pilihan.toUpperCase();

            switch (pilihan) {
                case "C":
                    System.out.println("ANDA MEMILIH MENU CRWATE");
                    System.out.println("-------------------------------------------------");
                    System.out.println("INPUT NEW DATA");
                    System.out.println("NIM        : ");
                    String nim = sc.nextLine();
                    System.out.println("NAMA       : ");
                    String nama = sc.nextLine();
                    System.out.println("ALAMAT     : ");
                    String alamat = sc.nextLine();
                    System.out.println("SEMESTER   : ");
                    int semester = sc.nextInt();
                    System.out.println("SKS        : ");
                    int sks = sc.nextInt();
                    System.out.println("IPK        : ");
                    double ipk = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("--------------------------------------------------");

                    boolean status = db.insert(nim, nama, alamat, semester, sks, ipk);
                    if (status==true){
                        System.out.println("data ditambahkan");
                    }else {
                        System.out.println("Gagal menambahkan");
                    }
                    break;
                case "R":
                    System.out.println("anda memilih menu Read!!");
                    db.view();
                    break;
                case "U":
                    System.out.println("ANDA MEMILIH MENU UPDATE");
                    db.view();
                    System.out.println("input NIM  yang akan diupdate");
                    String key = sc.nextLine();
                    int index = db.search(key);
                    if (index >= 0){
                        System.out.println("anda akan mengupdate data " + db.getData().get(index));
                        System.out.println("-------------------------------------------------");
                        System.out.println("INPUT NEW DATA");
                        System.out.println("NIM        : ");
                        nim = sc.nextLine();
                        System.out.println("NAMA       : ");
                        nama = sc.nextLine();
                        System.out.println("ALAMAT     : ");
                        alamat = sc.nextLine();
                        System.out.println("SEMESTER   : ");
                        semester = sc.nextInt();
                        System.out.println("SKS        : ");
                        sks = sc.nextInt();
                        System.out.println("IPK        : ");
                        ipk = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("--------------------------------------------------");
                        status = db.update(index, nim, nama, alamat, semester, sks, ipk);
                        if(status==true){
                            System.out.println("data berhasil diupdate");
                        }else {
                            System.err.println("Gagal mengupdate data");
                        }
                        System.out.println("--------------------------------------------------");
                    }else {
                        System.err.println("Mahasiswa dengan nim: " + key + "tidak ada");
                    }
                    break;
                case "D":
                    System.out.println("ANDA MEMILIH MENU DELETE");
                    db.view();
                    System.out.println("Input NIM mahasiswa yang akan dihapus: ");
                    key = sc.nextLine();
                    index = db.search(key);
                    if (index >= 0) {
                        System.out.println("Anda yakin ingin mengapus data " +db.getData().get(index) + "(Y/N");
                        System.out.println("pilih:  ");
                        pilihan = sc.nextLine();
                        if (pilihan.equalsIgnoreCase("Y")) {

                            status = db.delete(index);
                            if (status==true){
                                System.out.println("Data berhasil dihapus");
                            }else {
                                System.err.println("Gagal mengahpus");
                            }
                        }
                    }else{
                        System.out.println(("Mahasiswa dengan nim : " + key + " tidak ada"));
                    }
                    break;
                case "X":
                    System.out.println("Ingin Keluar?");
                    System.out.println("Jika ya(Y), jika tidak(N)");
                    System.out.println("pilih : ");
                    pilihan = sc.nextLine();
                    if (pilihan.equalsIgnoreCase("Y")){
                        System.exit(0);
                    }
                    break;

            }
        }
    }
}

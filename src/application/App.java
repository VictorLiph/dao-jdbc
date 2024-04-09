package application;


import java.util.Date;
import java.util.List;
import java.util.Scanner;

import DAO.DaoFactory;
import DAO.SellerDao;
import entities.Department;
import entities.Seller;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("\n*** TEST 1 - SELLER FINDBYID ***");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println();

        System.out.println("*** TEST 2 - SELLER FINDBYDEPARTMENT ***\n");
        Department department = new Department(2, null);
        List<Seller> listSellers = sellerDao.findByDepartment(department);
        listSellers.forEach(System.out::println);

        System.out.println();

        System.out.println("*** TEST 3 - SELLER FINDBYDEPARTMENT ***\n");
        listSellers = sellerDao.findAll();
        listSellers.forEach(System.out::println);

        System.out.println();

        System.out.println("*** TEST 4 - SELLER INSERT ***\n");
        Seller newSeller = new Seller(null, "Jack", "jack@gmail.com", new Date(), 3500.00, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted, new id= " + newSeller.getId());

        System.out.println();

        System.out.println("*** TEST 5 - SELLER UPDATE ***\n");
        Seller seller2 = sellerDao.findById(2);
        seller2.setName("Victor Lima");
        sellerDao.update(seller2);
        System.out.println("Update completed");

        System.out.println();

        System.out.println("*** TEST 6 - SELLER DELETE ***\n");
        sellerDao.deletById(9);
        System.out.println("Delete completed");
        }
}

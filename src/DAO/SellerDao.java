package DAO;

import java.util.List;

import entities.Department;
import entities.Seller;

public interface SellerDao {

    void insert(Seller obj);
    void update(Seller obj);
    void deletById(Integer id);
    Seller findById(Integer id);
    List<Seller> findByDepartment(Department department);
    List<Seller> findAll();
}

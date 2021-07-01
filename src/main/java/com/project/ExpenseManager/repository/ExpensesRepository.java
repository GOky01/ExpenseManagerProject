package com.project.ExpenseManager.repository;

import com.project.ExpenseManager.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses,Long> {
//    int updateUserSetStatusForName(int i, String sample);
////    @Modifying
////    @Query("update Expenses e set " +
////            "e.id = :id" +
////            "e.product = :product" +
////            "e.amount = :amount" +
////            " where e.date = :date")
////    int updateUserSetStatusForName(@Param("id") Long id,
////                                   @Param("product") String product);
////                                   @Param("amount") Integer amount);
////                                   @Param("date") String date);
}

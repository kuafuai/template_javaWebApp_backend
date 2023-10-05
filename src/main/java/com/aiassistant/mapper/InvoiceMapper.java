package com.aiassistant.mapper;

import com.aiassistant.model.Invoice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface InvoiceMapper {
    @Insert("INSERT INTO invoice (id, amount, customer_name) VALUES (#{id}, #{amount}, #{customerName})")
    int insertInvoice(Invoice invoice);

    @Select("SELECT * FROM invoice")
    List<Invoice> getAllInvoices();

    @Select("SELECT * FROM invoice WHERE id = #{id}")
    Invoice selectById(Integer id);
}

// Additional changes based on suggestions

package com.aiassistant.mapper;

import com.aiassistant.model.Invoice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface InvoiceMapper {
    @Insert("INSERT INTO invoice (id, amount, customer_name) VALUES (#{id}, #{amount}, #{customerName})")
    int insertInvoice(Invoice invoice);

    @Select("SELECT * FROM invoice")
    List<Invoice> getAllInvoices();

    @Select("SELECT * FROM invoice WHERE id = #{id}")
    Invoice selectById(Integer id);

    // Add proper error handling and exception handling in the methods
    // Example implementation:
    // @Insert("INSERT INTO invoice (id, amount, customer_name) VALUES (#{id}, #{amount}, #{customerName})")
    // int insertInvoice(Invoice invoice) throws DataAccessException;

    // Consider adding pagination support to the getAllInvoices() method
    // Example implementation:
    // @Select("SELECT * FROM invoice LIMIT #{offset}, #{limit}")
    // List<Invoice> getAllInvoices(@Param("offset") int offset, @Param("limit") int limit);

    // Add proper documentation and comments to the methods and interface
    // Example implementation:
    // /**
    //  * Inserts an invoice record into the database.
    //  *
    //  * @param invoice The invoice object to be inserted.
    //  * @return The number of rows affected by the insert operation.
    //  * @throws DataAccessException If an error occurs during the database operation.
    //  */
    // @Insert("INSERT INTO invoice (id, amount, customer_name) VALUES (#{id}, #{amount}, #{customerName})")
    // int insertInvoice(Invoice invoice) throws DataAccessException;

    // /**
    //  * Retrieves all invoice records from the database.
    //  *
    //  * @return A list of invoice objects.
    //  * @throws DataAccessException If an error occurs during the database operation.
    //  */
    // @Select("SELECT * FROM invoice")
    // List<Invoice> getAllInvoices() throws DataAccessException;

    // /**
    //  * Retrieves an invoice record from the database based on the invoice ID.
    //  *
    //  * @param id The ID of the invoice to be retrieved.
    //  * @return The invoice object.
    //  * @throws DataAccessException If an error occurs during the database operation.
    //  */
    // @Select("SELECT * FROM invoice WHERE id = #{id}")
    // Invoice selectById(Integer id) throws DataAccessException;
}
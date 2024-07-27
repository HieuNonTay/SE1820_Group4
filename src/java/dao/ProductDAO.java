/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Brand;
import entity.Category;
import entity.Color;
import entity.Product;
import entity.Size;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DBContext;

/**
 *
 * @author ASUS
 */
public class ProductDAO extends DBContext {

    public Vector<Product> getAll() {
        String sql = "select [ProductID], [Name], [model], [BrandID], [Categoryid], "
                + "[ColorID], [SizeID], [Description],Price, [Quantity], [sold], [view], [PublicationDate],[createdAt],[updatedAt] from Product";
        Vector<Product> vector = new Vector<>();
        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                int productId = rs.getInt(1);
                String name = rs.getNString(2);
                String model = rs.getNString(3);
                int brandId = rs.getInt(4);
                int categoryId = rs.getInt(5);
                int colorId = rs.getInt(6);
                int sizeId = rs.getInt(7);
                String description = rs.getNString(8);
                double price = rs.getDouble(9);
                int quantity = rs.getInt(10);
                int sold = rs.getInt(11);
                int view = rs.getInt(12);
                Timestamp publicationDate = rs.getTimestamp(13);
                Timestamp createdAt = rs.getTimestamp(14);
                Timestamp updatedAt = rs.getTimestamp(15);

                vector.add(new Product(productId, name, model, brandId, categoryId, colorId, sizeId, description, price, quantity, sold, view, publicationDate, createdAt, updatedAt));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public Vector<Product> getProductTOP5Sold() {
        String sql = "SELECT TOP 4 [ProductID], [Name], [model], [BrandID], [Categoryid], "
                + "[ColorID], [SizeID], [Description],Price, [Quantity], [sold], [view], [PublicationDate],[createdAt],[updatedAt] FROM Product\n"
                + "ORDER BY sold DESC";
        Vector<Product> vector = new Vector<>();
        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                int productId = rs.getInt(1);
                String name = rs.getNString(2);
                String model = rs.getNString(3);
                int brandId = rs.getInt(4);
                int categoryId = rs.getInt(5);
                int colorId = rs.getInt(6);
                int sizeId = rs.getInt(7);
                String description = rs.getNString(8);
                double price = rs.getDouble(9);
                int quantity = rs.getInt(10);
                int sold = rs.getInt(11);
                int view = rs.getInt(12);
                Timestamp publicationDate = rs.getTimestamp(13);
                Timestamp createdAt = rs.getTimestamp(14);
                Timestamp updatedAt = rs.getTimestamp(15);

                vector.add(new Product(productId, name, model, brandId, categoryId, colorId, sizeId, description, price, quantity, sold, view, publicationDate, createdAt, updatedAt));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public Vector<Product> getProductTOPNew() {
        String sql = "SELECT TOP 6 [ProductID], [Name], [model], [BrandID], [Categoryid], "
                + "[ColorID], [SizeID], [Description],Price, [Quantity], [sold], [view], [PublicationDate],[createdAt],[updatedAt] FROM Product\n"
                + "ORDER BY createdAt DESC";
        Vector<Product> vector = new Vector<>();
        ResultSet rs = getData(sql);

        try {
            while (rs.next()) {
                int productId = rs.getInt(1);
                String name = rs.getNString(2);
                String model = rs.getNString(3);
                int brandId = rs.getInt(4);
                int categoryId = rs.getInt(5);
                int colorId = rs.getInt(6);
                int sizeId = rs.getInt(7);
                String description = rs.getNString(8);
                double price = rs.getDouble(9);
                int quantity = rs.getInt(10);
                int sold = rs.getInt(11);
                int view = rs.getInt(12);
                Timestamp publicationDate = rs.getTimestamp(13);
                Timestamp createdAt = rs.getTimestamp(14);
                Timestamp updatedAt = rs.getTimestamp(15);

                vector.add(new Product(productId, name, model, brandId, categoryId, colorId, sizeId, description, price, quantity, sold, view, publicationDate, createdAt, updatedAt));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public Vector<Product> getBySql(String sql) {
        Vector<Product> vector = new Vector<>();
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                int productId = rs.getInt(1);
                String name = rs.getNString(2);
                String model = rs.getNString(3);
                int brandId = rs.getInt(4);
                int categoryId = rs.getInt(5);
                int colorId = rs.getInt(6);
                int sizeId = rs.getInt(7);
                String description = rs.getNString(8);
                double price = rs.getDouble(9);
                int quantity = rs.getInt(10);
                int sold = rs.getInt(11);
                int view = rs.getInt(12);
                Timestamp publicationDate = rs.getTimestamp(13);
                Timestamp createdAt = rs.getTimestamp(14);
                Timestamp updatedAt = rs.getTimestamp(15);

                vector.add(new Product(productId, name, model, brandId, categoryId, colorId, sizeId, description, price, quantity, sold, view, publicationDate, createdAt, updatedAt));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public Product getById(int id) {
        String sql = "Select [ProductID], [Name], [model], [BrandID], [Categoryid], "
                + "[ColorID], [SizeID], [Description],Price, [Quantity], [sold], [view], [PublicationDate],[createdAt],[updatedAt] From Product a Where a.ProductID = ?;";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                int productId = rs.getInt(1);
                String name = rs.getNString(2);
                String model = rs.getNString(3);
                int brandId = rs.getInt(4);
                int categoryId = rs.getInt(5);
                int colorId = rs.getInt(6);
                int sizeId = rs.getInt(7);
                String description = rs.getNString(8);
                double price = rs.getDouble(9);
                int quantity = rs.getInt(10);
                int sold = rs.getInt(11);
                int view = rs.getInt(12);
                Timestamp publicationDate = rs.getTimestamp(13);
                Timestamp createdAt = rs.getTimestamp(14);
                Timestamp updatedAt = rs.getTimestamp(15);

                return new Product(productId, name, model, brandId, categoryId, colorId, sizeId, description, price, quantity, sold, view, publicationDate, createdAt, updatedAt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Map<String, Object>> getProductById(int id) {
        String sql = "SELECT p.ProductID, p.Model, p.Name, p.Description, p.CategoryID, p.Price, p.Sold, p.Quantity, "
                + "p.ColorID, p.SizeID, p.BrandID, p.[view], p.PublicationDate, p.CreatedAt, p.UpdatedAt, pi.alt, pi.source "
                + "FROM Product p LEFT JOIN ProductImage pi ON p.ProductID = pi.ProductID "
                + "WHERE p.ProductID = ?";

        List<Map<String, Object>> products = new ArrayList<>();
        Map<Integer, Map<String, Object>> productMap = new HashMap<>();

        try (PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setInt(1, id);
            try (ResultSet rs = pre.executeQuery()) {
                while (rs.next()) {
                    int productId = rs.getInt("ProductID");
                    Map<String, Object> product = productMap.get(productId);

                    if (product == null) {
                        product = new HashMap<>();
                        product.put("ProductID", productId);
                        product.put("Model", rs.getString("Model"));
                        product.put("Name", rs.getString("Name"));
                        product.put("Description", rs.getString("Description"));
                        product.put("CategoryID", rs.getInt("CategoryID"));
                        product.put("Price", rs.getDouble("Price"));
                        product.put("Sold", rs.getInt("Sold"));
                        product.put("Quantity", rs.getInt("Quantity"));
                        product.put("ColorID", rs.getInt("ColorID"));
                        product.put("SizeID", rs.getInt("SizeID"));
                        product.put("BrandID", rs.getInt("BrandID"));
                        product.put("View", rs.getInt("View"));
                        product.put("PublicationDate", rs.getTimestamp("PublicationDate"));
                        product.put("CreatedAt", rs.getTimestamp("CreatedAt"));
                        product.put("UpdatedAt", rs.getTimestamp("UpdatedAt"));
                        product.put("Images", new ArrayList<Map<String, String>>());
                        productMap.put(productId, product);
                        products.add(product);
                    }

                    Map<String, String> image = new HashMap<>();
                    image.put("alt", rs.getString("alt"));
                    image.put("source", rs.getString("source"));
                    ((List<Map<String, String>>) product.get("Images")).add(image);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return products;
    }

    public List<Product> getAllProduct() {
        String sql = "SELECT * FROM Product";
        List<Product> products = new ArrayList<>();

        try (PreparedStatement pre = conn.prepareStatement(sql)) {
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                int productId = rs.getInt(1);
                String name = rs.getNString(2);
                String model = rs.getNString(3);
                int brandId = rs.getInt(4);
                int categoryID = rs.getInt(5);
                int colorId = rs.getInt(6);
                int sizeId = rs.getInt(7);
                String description = rs.getNString(8);
                double price = rs.getDouble(9);
                int quantity = rs.getInt(10);
                int sold = rs.getInt(11);
                int view = rs.getInt(12);
                Timestamp publicationDate = rs.getTimestamp(13);
                Timestamp createdAt = rs.getTimestamp(14);
                Timestamp updatedAt = rs.getTimestamp(15);

                products.add(new Product(productId, name, model, brandId, categoryID, colorId, sizeId, description, price, quantity, sold, view, publicationDate, createdAt, updatedAt));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return products;
    }

    public List<Map<String, Object>> getAllProductImage() throws SQLException {
        String sql = "SELECT p.ProductID, p.Model, p.Name, p.Description, p.CategoryID, p.Price, p.Sold, p.Quantity, pi.alt, pi.source "
                + "FROM Product p LEFT JOIN ProductImage pi ON p.ProductID = pi.ProductID";

        List<Map<String, Object>> products = new ArrayList<>();

        try (PreparedStatement pre = conn.prepareStatement(sql)) {
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                int productId = rs.getInt("ProductID");
                Map<String, Object> product = null;

                if (product == null) {
                    product = new HashMap<>();
                    product.put("ProductID", productId);
                    product.put("Model", rs.getString("Model"));
                    product.put("Name", rs.getString("Name"));
                    product.put("Description", rs.getString("Description"));
                    product.put("CategoryID", rs.getInt("CategoryID"));
                    product.put("Price", rs.getDouble("Price"));
                    product.put("Sold", rs.getInt("Sold"));
                    product.put("Quantity", rs.getInt("Quantity"));
                    product.put("Images", new ArrayList<Map<String, String>>());
                    products.add(product);
                }
                Map<String, String> image = new HashMap<>();
                image.put("alt", rs.getString("alt"));
                image.put("source", rs.getString("source"));
                ((List<Map<String, String>>) product.get("Images")).add(image);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return products;
    }

//    public Vector<Product> searchProduct(String name) {
//        Vector<Product> vector = new Vector<>();
//        String sql = "select * from product where name like '%" + name + "%'";
//        vector = getBySql(sql);
//        return vector;
//    }
    public List<Map<String, Object>> searchProduct(String name) {
        String sql = "SELECT p.ProductID, p.Model, p.Name, p.Description, p.CategoryID, p.Price, p.Sold, p.Quantity, pi.alt, pi.source "
                + "FROM Product p LEFT JOIN ProductImage pi ON p.ProductID = pi.ProductID "
                + "WHERE p.Name LIKE ?";

        List<Map<String, Object>> products = new ArrayList<>();

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + name + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int productId = rs.getInt("ProductID");
                    Map<String, Object> product = null;

                    // Check if the product is already in the list
                    for (Map<String, Object> existingProduct : products) {
                        if (existingProduct.get("ProductID").equals(productId)) {
                            product = existingProduct;
                            break;
                        }
                    }

                    if (product == null) {
                        product = new HashMap<>();
                        product.put("ProductID", productId);
                        product.put("Model", rs.getString("Model"));
                        product.put("Name", rs.getString("Name"));
                        product.put("Description", rs.getString("Description"));
                        product.put("CategoryID", rs.getInt("CategoryID"));
                        product.put("Price", rs.getDouble("Price"));
                        product.put("Sold", rs.getInt("Sold"));
                        product.put("Quantity", rs.getInt("Quantity"));
                        product.put("Images", new ArrayList<Map<String, String>>());
                        products.add(product);
                    }

                    Map<String, String> image = new HashMap<>();
                    image.put("alt", rs.getString("alt"));
                    image.put("source", rs.getString("source"));
                    ((List<Map<String, String>>) product.get("Images")).add(image);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return products;
    }

    public List<Size> getSizeByID(int product_id) {
        List<Size> list = new ArrayList<>();
        String sql = "select * from product_size where product_id=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, product_id);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                list.add(new Size(rs.getInt(1), rs.getInt(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Color getColorByID(int product_id) {

        String sql = "select * from Color where ColorID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, product_id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                return new Color(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public String findCategoryByProductId(int productId) {
        String sql = "SELECT c.CategoryName FROM Category c \n"
                + "JOIN Product p ON p.CategoryID = c.CategoryID WHERE p.CategoryID = ?";
        try (PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setInt(1, productId);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                return rs.getString("CategoryName");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Integer findCategoryIdByProductId(int productId) {
        String sql = "SELECT CategoryID FROM Product WHERE ProductID = ?;";
        try (PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setInt(1, productId);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                return rs.getInt("CategoryID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Map<String, Object>> findProductsByCategoryId(int categoryId) {
        String sql = "SELECT p.ProductID, p.Model, p.Name, p.Description, p.CategoryID, p.Price, p.Sold, p.Quantity, pi.alt, pi.source "
                + "FROM Product p LEFT JOIN ProductImage pi ON p.ProductID = pi.ProductID WHERE p.CategoryID = ?;";

        List<Map<String, Object>> products = new ArrayList<>();

        try (PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setInt(1, categoryId);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                int productId = rs.getInt("ProductID");
                Map<String, Object> product = null;

                // Check if the product is already in the list
                for (Map<String, Object> existingProduct : products) {
                    if ((int) existingProduct.get("ProductID") == productId) {
                        product = existingProduct;
                        break;
                    }
                }

                // If the product is not in the list, add it
                if (product == null) {
                    product = new HashMap<>();
                    product.put("ProductID", productId);
                    product.put("Model", rs.getString("Model"));
                    product.put("Name", rs.getString("Name"));
                    product.put("Description", rs.getString("Description"));
                    product.put("CategoryID", rs.getInt("CategoryID"));
                    product.put("Price", rs.getDouble("Price"));
                    product.put("Sold", rs.getInt("Sold"));
                    product.put("Quantity", rs.getInt("Quantity"));
                    product.put("Images", new ArrayList<Map<String, String>>());
                    products.add(product);
                }

                // Add the image data to the product
                Map<String, String> image = new HashMap<>();
                image.put("alt", rs.getString("alt"));
                image.put("source", rs.getString("source"));
                ((List<Map<String, String>>) product.get("Images")).add(image);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return products;
    }

    public List<Map<String, Object>> filterProductsByPrice(double passPrice, String sortOrder) {
        StringBuilder sqlBuilder = new StringBuilder("SELECT p.ProductID, p.Model, p.Name, p.Description, p.CategoryID, p.Price, p.Sold, p.Quantity, pi.alt, pi.source "
                + "FROM Product p LEFT JOIN ProductImage pi ON p.ProductID = pi.ProductID");

        // Add the price condition if passPrice is greater than 0
        if (passPrice > 0) {
            sqlBuilder.append(" WHERE p.Price < ?");
        }

        // Append sorting order to the query if specified
        if ("ascending".equalsIgnoreCase(sortOrder)) {
            sqlBuilder.append(" ORDER BY p.Price ASC");
        } else if ("decreasing".equalsIgnoreCase(sortOrder)) {
            sqlBuilder.append(" ORDER BY p.Price DESC");
        }

        String sql = sqlBuilder.toString();
        List<Map<String, Object>> products = new ArrayList<>();

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Set the price parameter if passPrice is greater than 0
            if (passPrice > 0) {
                pstmt.setDouble(1, passPrice);
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int productId = rs.getInt("ProductID");
                    Map<String, Object> product = null;

                    // Find the product in the list if it already exists
                    for (Map<String, Object> existingProduct : products) {
                        if (existingProduct.get("ProductID").equals(productId)) {
                            product = existingProduct;
                            break;
                        }
                    }

                    if (product == null) {
                        product = new HashMap<>();
                        product.put("ProductID", productId);
                        product.put("Model", rs.getString("Model"));
                        product.put("Name", rs.getString("Name"));
                        product.put("Description", rs.getString("Description"));
                        product.put("CategoryID", rs.getInt("CategoryID"));
                        product.put("Price", rs.getDouble("Price"));
                        product.put("Sold", rs.getInt("Sold"));
                        product.put("Quantity", rs.getInt("Quantity"));
                        product.put("Images", new ArrayList<Map<String, String>>());
                        products.add(product);
                    }

                    Map<String, String> image = new HashMap<>();
                    image.put("alt", rs.getString("alt"));
                    image.put("source", rs.getString("source"));
                    ((List<Map<String, String>>) product.get("Images")).add(image);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public boolean insertProduct(Product product, String imageSource) throws SQLException {
        conn.setAutoCommit(false);

        String insertProductSQL = "INSERT INTO Product (Name, Model, BrandID, CategoryID, ColorID, SizeID, Description, Price, Quantity, Sold, [View], PublicationDate, CreatedAt, UpdatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String checkImageSQL = "SELECT COUNT(*) FROM ProductImage WHERE ProductID = ?";
        String insertImageSQL = "INSERT INTO ProductImage (ProductID, alt, source) VALUES (?, ?, ?)";
        String updateImageSQL = "UPDATE ProductImage SET alt = ?, source = ? WHERE ProductID = ?";

        try (PreparedStatement pstmtProduct = conn.prepareStatement(insertProductSQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmtProduct.setString(1, product.getName());
            pstmtProduct.setString(2, product.getModel());
            pstmtProduct.setInt(3, product.getBrandId());
            pstmtProduct.setInt(4, product.getCatergoryId());
            pstmtProduct.setInt(5, product.getColorId());
            pstmtProduct.setInt(6, product.getSizeId());
            pstmtProduct.setString(7, product.getDescription());
            pstmtProduct.setDouble(8, product.getPrice());
            pstmtProduct.setInt(9, product.getQuantity());
            pstmtProduct.setInt(10, product.getSold());
            pstmtProduct.setInt(11, product.getView());
            pstmtProduct.setTimestamp(12, product.getPublicationDate());
            pstmtProduct.setTimestamp(13, product.getCreatedAt());
            pstmtProduct.setTimestamp(14, product.getUpdatedAt());

            int rowsAffected = pstmtProduct.executeUpdate();

            if (rowsAffected == 0) {
                conn.rollback();
                return false;
            }

            int productId;
            try (ResultSet generatedKeys = pstmtProduct.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    productId = generatedKeys.getInt(1);
                } else {
                    conn.rollback();
                    throw new SQLException("Failed to insert product, no ID obtained.");
                }
            }

            int imageCount = 0;
            try (PreparedStatement pstmtCheck = conn.prepareStatement(checkImageSQL)) {
                pstmtCheck.setInt(1, productId);
                try (ResultSet rs = pstmtCheck.executeQuery()) {
                    if (rs.next()) {
                        imageCount = rs.getInt(1);
                    }
                }
            }

            if (imageCount == 0) {
                try (PreparedStatement pstmtInsertImage = conn.prepareStatement(insertImageSQL)) {
                    String imageAlt = "Image";
                    pstmtInsertImage.setInt(1, productId);
                    pstmtInsertImage.setString(2, imageAlt);
                    pstmtInsertImage.setString(3, imageSource);
                    pstmtInsertImage.executeUpdate();
                }
            } else {
                try (PreparedStatement pstmtUpdateImage = conn.prepareStatement(updateImageSQL)) {
                    String imageAlt = "Image";
                    pstmtUpdateImage.setString(1, imageAlt);
                    pstmtUpdateImage.setString(2, imageSource);
                    pstmtUpdateImage.setInt(3, productId);
                    pstmtUpdateImage.executeUpdate();
                }
            }

            conn.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
            return false;
        }
    }

    public boolean deleteProductById(int productId) {
        String deleteImageSQL = "DELETE FROM ProductImage WHERE ProductID = ?";
        String deleteProductSQL = "DELETE FROM Product WHERE ProductID = ?";

        try {
            conn.setAutoCommit(false);

            // Delete related images first
            try (PreparedStatement pstmtImage = conn.prepareStatement(deleteImageSQL)) {
                pstmtImage.setInt(1, productId);
                pstmtImage.executeUpdate();
            }

            // Then delete the product
            try (PreparedStatement pstmtProduct = conn.prepareStatement(deleteProductSQL)) {
                pstmtProduct.setInt(1, productId);
                int rowsAffected = pstmtProduct.executeUpdate();
                conn.commit();
                return rowsAffected > 0;
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateProduct(int productId, String name, String model, int brandId, int categoryId, int colorId, int sizeId, String description, double price, int quantity, Timestamp updatedAt, String imageSource) throws SQLException {
        String sql = "UPDATE Product SET Name = ?, Model = ?, BrandID = ?, CategoryID = ?, ColorID = ?, SizeID = ?, Description = ?, Price = ?, Quantity = ?, UpdatedAt = ? WHERE ProductID = ?";
        conn.setAutoCommit(false);
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, model);
            pstmt.setInt(3, brandId);
            pstmt.setInt(4, categoryId);
            pstmt.setInt(5, colorId);
            pstmt.setInt(6, sizeId);
            pstmt.setString(7, description);
            pstmt.setDouble(8, price);
            pstmt.setInt(9, quantity);
            pstmt.setTimestamp(10, updatedAt);
            pstmt.setInt(11, productId);

            String checkImageSQL = "SELECT COUNT(*) FROM ProductImage WHERE ProductID = ?";
            int count = 0;
            try (PreparedStatement pstmtCheck = conn.prepareStatement(checkImageSQL)) {
                pstmtCheck.setInt(1, productId);
                try (ResultSet rs = pstmtCheck.executeQuery()) {
                    if (rs.next()) {
                        count = rs.getInt(1);
                    }
                }
            }

            if (count == 0) {
                // Insert new ProductImage
                String insertImageSQL = "INSERT INTO ProductImage (ProductID, alt, source) VALUES (?, ?, ?)";
                try (PreparedStatement pstmtInsert = conn.prepareStatement(insertImageSQL)) {
                    String imageAlt = "Image";
                    pstmtInsert.setInt(1, productId);
                    pstmtInsert.setString(2, imageAlt);
                    pstmtInsert.setString(3, imageSource);
                    pstmtInsert.executeUpdate();
                }
            } else {
                // Update existing ProductImage
                String updateImageSQL = "UPDATE ProductImage SET alt = ?, source = ? WHERE ProductID = ?";
                try (PreparedStatement pstmtUpdate = conn.prepareStatement(updateImageSQL)) {
                    String imageAlt = name;
                    pstmtUpdate.setString(1, imageAlt);
                    pstmtUpdate.setString(2, imageSource);
                    pstmtUpdate.setInt(3, productId);
                    pstmtUpdate.executeUpdate();
                }

            }

            int rowsAffected = pstmt.executeUpdate();
            conn.commit();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Restore auto-commit mode
            conn.setAutoCommit(true);
        }
    }

    public List<Brand> getBrands(String sql) {
        List<Brand> list = new ArrayList<>();
        try {
            Statement st = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int BrandID = rs.getInt(1);
                String BrandName = rs.getString(2);
                Brand brand = new Brand(BrandID, BrandName);
                list.add(brand);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public String getImage(int productId) {
        String image = "";
        String sql = "SELECT TOP 1 source FROM ProductImage WHERE ProductID = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                image = rs.getString("source");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return image;
    }

    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
//        Vector<Product> list = dao.getProductTOP5Sold();
//
//        for (Product product : list) {
//            System.out.println(product);
//        }
//        List<Product> categorys = dao.filterProductsByPrice(30, "ascending");
//        categorys.stream().forEach(y -> System.err.println(y.getPrice()));
        String img = dao.getImage(8);
        System.out.println();
    }
}

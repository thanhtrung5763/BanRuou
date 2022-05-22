package vn.liquor.util;

import vn.liquor.dao.impl.*;

public class SingletonServiceUtils {

    private static BillDaoImpl billDaoImpl = null;
    private static CartDaoImpl cartDaoImpl = null;
    private static CartItemDaoImpl cartItemDaoImpl = null;
    private static CategoryDaoImpl categoryDaoImpl = null;
    private static CityDaoImpl cityDaoImpl = null;
    private static LoginDaoImpl loginDaoImpl = null;
    private static OrderDaoImpl orderDaoImpl = null;
    private static ProductDaoImpl productDaoImpl = null;
    private static SellerDaoImpl sellerDaoImpl = null;
    private static UserDaoImpl userDaoImpl = null;

    public static BillDaoImpl getBillDaoImpl() {
        if (billDaoImpl == null) {
            billDaoImpl = new BillDaoImpl();
        }
        return billDaoImpl;
    }

    public static CartDaoImpl getCartDaoImpl() {
        if (cartDaoImpl == null) {
            cartDaoImpl = new CartDaoImpl();
        }
        return cartDaoImpl;
    }

    public static CartItemDaoImpl getCartItemDaoImpl() {
        if (cartItemDaoImpl == null) {
            cartItemDaoImpl = new CartItemDaoImpl();
        }
        return cartItemDaoImpl;
    }

    public static CategoryDaoImpl getCategoryDaoImpl() {
        if (categoryDaoImpl == null) {
            categoryDaoImpl = new CategoryDaoImpl();
        }
        return categoryDaoImpl;
    }

    public static CityDaoImpl getCityDaoImpl() {
        if (cityDaoImpl == null) {
            cityDaoImpl = new CityDaoImpl();
        }
        return cityDaoImpl;
    }

    public static LoginDaoImpl getLoginDaoImpl() {
        if (loginDaoImpl == null) {
            loginDaoImpl = new LoginDaoImpl();
        }
        return loginDaoImpl;
    }

    public static OrderDaoImpl getOrderDaoImpl() {
        if (orderDaoImpl == null) {
            orderDaoImpl = new OrderDaoImpl();
        }
        return orderDaoImpl;
    }

    public static ProductDaoImpl getProductDaoImpl() {
        if (productDaoImpl == null) {
            productDaoImpl = new ProductDaoImpl();
        }
        return productDaoImpl;
    }

    public static SellerDaoImpl getSellerDaoImpl() {
        if (sellerDaoImpl == null) {
            sellerDaoImpl = new SellerDaoImpl();
        }
        return sellerDaoImpl;
    }

    public static UserDaoImpl getUserDaoImpl() {
        if (userDaoImpl == null) {
            userDaoImpl = new UserDaoImpl();
        }
        return userDaoImpl;
    }
}

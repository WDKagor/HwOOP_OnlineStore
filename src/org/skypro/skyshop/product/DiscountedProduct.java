package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discount;

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        if (basePrice > 1) {
            this.basePrice = basePrice;
        } else {
            throw new IllegalArgumentException("Цена не может ровняться 0 или быть отрицательной");
        }
        if (discount >= 0 && discount <= 100)
        {
            this.discount = discount;
        } else {
            throw new IllegalArgumentException("Скидка должна быть от 0 до 100 включительно");
        }
    }

    @Override
    public int getPrice() {
        return (basePrice * (100-discount))/100;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " руб. (скидка " + discount + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}

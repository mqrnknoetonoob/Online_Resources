// 1. PaymentProcessor Interface
interface PaymentProcessor {
    void processPayment();
}

// 2. Concrete Implementations
class Cash implements PaymentProcessor {
    @Override
    public void processPayment() {
        System.out.println("Processing cash payment...");
    }
}

class CreditCard implements PaymentProcessor {
    @Override
    public void processPayment() {
        System.out.println("Processing credit card payment...");
    }
}

class Coupon implements PaymentProcessor {
    @Override
    public void processPayment() {
        System.out.println("Processing coupon payment...");
    }
}

// 3. Factory Class (GetPayment)
class GetPayment {
    public static PaymentProcessor getProcessor(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("CASH")) {
            return new Cash();
        } else if (type.equalsIgnoreCase("CREDITCARD")) {
            return new CreditCard();
        } else if (type.equalsIgnoreCase("COUPON")) {
            return new Coupon();
        }
        return null;
    }
}

// 4. Client Class (Kiosk)
public class Kiosk {
    public static void main(String[] args) {
        // Cash payment processor neoat
        PaymentProcessor cashPayment = GetPayment.getProcessor("CASH");
        if (cashPayment != null) {
            cashPayment.processPayment();
        }

        // Credit Card payment processor neoat
        PaymentProcessor creditCardPayment = GetPayment.getProcessor("CREDITCARD");
        if (creditCardPayment != null) {
            creditCardPayment.processPayment();
        }

        // Coupon payment processor neoat
        PaymentProcessor couponPayment = GetPayment.getProcessor("COUPON");
        if (couponPayment != null) {
            couponPayment.processPayment();
        }
    }
}
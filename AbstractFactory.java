// 1. Abstract Products (Product Interfaces)
interface Chair {
    void create();
}

interface Sofa {
    void create();
}

interface CoffeeTable {
    void create();
}

// 2. Concrete Products for "Art Deco" Variant
class ArtDecoChair implements Chair {
    @Override
    public void create() {
        System.out.println("Art Deco Chair");
    }
}

class ArtDecoSofa implements Sofa {
    @Override
    public void create() {
        System.out.println("Art Deco Sofa");
    }
}

class ArtDecoCoffeeTable implements CoffeeTable {
    @Override
    public void create() {
        System.out.println("Art Deco Coffee Table");
    }
}

// 2. Concrete Products for "Victorian" Variant
class VictorianChair implements Chair {
    @Override
    public void create() {
        System.out.println("Victorian Chair");
    }
}

class VictorianSofa implements Sofa {
    @Override
    public void create() {
        System.out.println("Victorian Sofa");
    }
}

class VictorianCoffeeTable implements CoffeeTable {
    @Override
    public void create() {
        System.out.println("Victorian Coffee Table");
    }
}

// 2. Concrete Products for "Modern" Variant
class ModernChair implements Chair {
    @Override
    public void create() {
        System.out.println("Modern Chair");
    }
}

class ModernSofa implements Sofa {
    @Override
    public void create() {
        System.out.println("Modern Sofa");
    }
}

class ModernCoffeeTable implements CoffeeTable {
    @Override
    public void create() {
        System.out.println("Modern Coffee Table");
    }
}

// 3. Abstract Factory Interface
interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
    CoffeeTable createCoffeeTable();
}

// 4. Concrete Factories for each variant family
class ArtDecoFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ArtDecoChair();
    }

    @Override
    public Sofa createSofa() {
        return new ArtDecoSofa();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new ArtDecoCoffeeTable();
    }
}

class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new VictorianCoffeeTable();
    }
}

class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new ModernCoffeeTable();
    }
}

// 5. Client Application
class Application {
    private Chair chair;
    private Sofa sofa;
    private CoffeeTable coffeeTable;

    public Application(FurnitureFactory factory) {
        chair = factory.createChair();
        sofa = factory.createSofa();
        coffeeTable = factory.createCoffeeTable();
    }

    public void buildFurniture() {
        chair.create();
        sofa.create();
        coffeeTable.create();
    }
}

// Main Class (Demo)
public class Main {
    public static void main(String[] args) {
        // Modern family-er furniture toiri korar jonno:
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        Application app1 = new Application(modernFactory);
        System.out.println("--- Modern Furniture Set ---");
        app1.buildFurniture();

        System.out.println();

        // Victorian family-er furniture toiri korar jonno:
        FurnitureFactory victorianFactory = new VictorianFurnitureFactory();
        Application app2 = new Application(victorianFactory);
        System.out.println("--- Victorian Furniture Set ---");
        app2.buildFurniture();
    }
}
// Pure Normal Class (Kono static keyword or Enum nai)
class DatabaseConnection {
    public DatabaseConnection() {
        System.out.println("New DatabaseConnection instance created in memory!");
    }

    public void showMessage() {
        System.out.println("Connected to Database!");
    }
}

// Memory Registry Container (Jeta instance dhore rakhe)
class SingletonRegistry {
    // Memory Cache
    private static final Map<String, Object> registry = new HashMap<>();

    public static Object getInstance(String className, Supplier<Object> creator) {
        if (!registry.containsKey(className)) {
            // Hotat purono instance na thakle fully nuthon toiri kore rakhe
            registry.put(className, creator.get());
        }
        // Purono instance memory theke ferot dey
        return registry.get(className);
    }
}

// Demo
public class Main {
    public static void main(String[] args) {
        // App-er normal class-e kono static nai, kintu Registry inner memory tracking korse
        DatabaseConnection db1 = (DatabaseConnection) SingletonRegistry.getInstance(
            "DatabaseConnection", 
            DatabaseConnection::new
        );

        DatabaseConnection db2 = (DatabaseConnection) SingletonRegistry.getInstance(
            "DatabaseConnection", 
            DatabaseConnection::new
        );

        // Tracking proof: Same object reference
        System.out.println("Duto reference ki eki object? " + (db1 == db2));
    }
}
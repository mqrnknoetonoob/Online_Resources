// Product Class
class Computer {
    // Required parameters
    private String HDD;
    private String RAM;

    // Optional parameters
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;

    // Private constructor jate shudhu Builder class bebohar kore object create kora jaay
    private Computer(ComputerBuilder builder) {
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    // Getters
    public String getHDD() { return HDD; }
    public String getRAM() { return RAM; }
    public boolean isGraphicsCardEnabled() { return isGraphicsCardEnabled; }
    public boolean isBluetoothEnabled() { return isBluetoothEnabled; }

    @Override
    public String toString() {
        return "Computer [HDD=" + HDD + ", RAM=" + RAM + 
               ", GraphicsCard=" + isGraphicsCardEnabled + 
               ", Bluetooth=" + isBluetoothEnabled + "]";
    }

    // Builder Class (Static Nested Class)
    public static class ComputerBuilder {
        // Required parameters
        private String HDD;
        private String RAM;

        // Optional parameters
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        // Constructor for required parameters
        public ComputerBuilder(String HDD, String RAM) {
            this.HDD = HDD;
            this.RAM = RAM;
        }

        // Setter methods for optional parameters (returns 'this' for method chaining)
        public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        // Final build method to create Computer object
        public Computer build() {
            return new Computer(this);
        }
    }
}

// Main Class (Demo)
public class Main {
    public static void main(String[] args) {
        // Method chaining bebohar kore Computer object toiri:
        Computer comp1 = new Computer.ComputerBuilder("500 GB", "2 GB")
                .setBluetoothEnabled(true)
                .build();

        Computer comp2 = new Computer.ComputerBuilder("1 TB", "16 GB")
                .setGraphicsCardEnabled(true)
                .setBluetoothEnabled(true)
                .build();

        System.out.println(comp1);
        System.out.println(comp2);
    }
}
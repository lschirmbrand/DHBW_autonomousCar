public class Lidar {

    private enum LidarVariantE{
        LIDAR_NG, LIDAR_XT
    }

    private static Lidar instance = new Lidar();
    public Lidar.Port port;

    private LidarVariantE lidarVariant;
    private boolean isOn = false;
    private boolean alreadyChanged = false;


    public String innerSetLidarVariant(String variant){
        if(!alreadyChanged){
            if(variant.equals(LidarVariantE.LIDAR_NG.toString())){
                this.lidarVariant = LidarVariantE.LIDAR_NG;
                this.alreadyChanged = true;
                return "Lidar was finally set to Variant: NG";
            }
            else{
                this.lidarVariant = LidarVariantE.LIDAR_XT;
                this.alreadyChanged = true;
                return "Lidar was finally set to Variant: XT";
            }
        }
        else{
            return "Lidar was already changed and therefore cant be changed anymore.";
        }
    }

    public String innerLidarOn(){
        if(isOn){
            return "Lidar was already: On";
        }
        else{
            this.isOn = true;
            return "Lidar was turned: On";
        }
    }

    public String innerLidarOff(){
        if(!isOn){
            return "Lidar was already: Off";
        }
        else{
            this.isOn = false;
            return "Lidar was turned: On";
        }
    }


    // inner class port
    public class Port implements ILidar {

        @Override
        public String lidarOn() {
            return innerLidarOn();
        }

        @Override
        public String lidarOff() {
            return innerLidarOff();
        }

        @Override
        public String setLidarVariant(String variant) {
            return innerSetLidarVariant(variant);
        }
    }
}
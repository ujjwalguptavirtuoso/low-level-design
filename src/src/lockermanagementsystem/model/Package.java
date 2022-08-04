package lockermanagementsystem.model;

public class Package implements LockerItem{

        private final String id;
        private final Size size;

         public Package( final String id, final Size size) {
            this.id = id;
            this.size = size;
        }

    @Override
    public Size getSize() {
        return size;
    }
}

package lockermanagementsystem.model;

public class Size {

    private final Double width;
    private final Double height;

    public Size(final Double width,final Double height) {
        this.width = width;
        this.height = height;
    }

    public boolean canAccommodate(final Size sizeToAccommodate) {
        return this.width >= sizeToAccommodate.width && this.height >= sizeToAccommodate.height;
    }
}

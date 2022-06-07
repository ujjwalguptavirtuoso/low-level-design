package elevator;

public class Request implements Comparable<Request>{


    private ExternalRequest externalRequest;
    private InternalRequest internalRequest;

    public Request(ExternalRequest externalRequest, InternalRequest internalRequest) {
        this.externalRequest = externalRequest;
        this.internalRequest = internalRequest;
    }


    public ExternalRequest getExternalRequest() {
        return externalRequest;
    }

    public void setExternalRequest(ExternalRequest externalRequest) {
        this.externalRequest = externalRequest;
    }

    public InternalRequest getInternalRequest() {
        return internalRequest;
    }

    public void setInternalRequest(InternalRequest internalRequest) {
        this.internalRequest = internalRequest;
    }

    @Override
    public int compareTo(Request req) {
        if (this.getInternalRequest().getDestinationFloor() == req.getInternalRequest().getDestinationFloor())
            return 0;
        else if (this.getInternalRequest().getDestinationFloor() > req.getInternalRequest().getDestinationFloor())
            return 1;
        else
            return -1;
    }
}


class ExternalRequest{
    private Direction directionToGo;
    private int sourceFloor;

    public ExternalRequest(Direction directionToGo, int sourceFloor) {
        this.directionToGo = directionToGo;
        this.sourceFloor = sourceFloor;
    }

    public Direction getDirectionToGo() {
        return directionToGo;
    }

    public void setDirectionToGo(Direction directionToGo) {
        this.directionToGo = directionToGo;
    }

    public int getSourceFloor() {
        return sourceFloor;
    }

    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }
}

class InternalRequest{
    private int destinationFloor;

    public InternalRequest(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }
    public int getDestinationFloor() {
        return destinationFloor;
    }
    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }
}

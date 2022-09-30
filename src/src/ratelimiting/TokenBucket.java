package ratelimiting;

public class TokenBucket {

    private final long maxBucketSize;
    private final long refillRate; //tokens to add per sec

    private long currentBucketSize;
    private long lastRefillTimeStamp;

    public TokenBucket(long maxBucketSize, long refillRate) {
        this.maxBucketSize = maxBucketSize;
        this.refillRate = refillRate;

        this.currentBucketSize = maxBucketSize;
        this.lastRefillTimeStamp = System.nanoTime();
    }

    public synchronized boolean allowRequest(long tokens){ // we have to make it thread safe so that concurrent operations to bucket size are prevented
        refill();

        if(currentBucketSize >= tokens){
            currentBucketSize -= tokens;
            return true;
        }
        return false;
    }

    private void refill(){
        long now = System.nanoTime();
        long tokensToAdd = (long) ((now - lastRefillTimeStamp) * refillRate / (1e9)); // 1e9 - 1000000000 --> nano seconds in a sec

        currentBucketSize = Math.min(maxBucketSize, currentBucketSize + tokensToAdd);
        lastRefillTimeStamp = now;
    }
}

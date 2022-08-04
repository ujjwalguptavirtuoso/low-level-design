package lockermanagementsystem.strategies;

import lombok.NonNull;

public class OtpGeneratorrandom implements IOtpGenerator{

    private final int otpLength;
    private final IRandomGenerator randomGenerator;

    public OtpGeneratorrandom(int otpLength, IRandomGenerator randomGenerator) {
        this.otpLength = otpLength;
        this.randomGenerator = randomGenerator;
    }

    @NonNull
    @Override
    public String generateOtp() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < otpLength; i++) {
            stringBuilder.append(randomGenerator.getRandomNumber(10));
        }
        return stringBuilder.toString();
    }
}

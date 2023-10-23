package recipemanager.projekt.recipemanager.user.tfa;

import dev.samstevens.totp.code.CodeGenerator;
import dev.samstevens.totp.code.CodeVerifier;
import dev.samstevens.totp.code.DefaultCodeGenerator;
import dev.samstevens.totp.code.DefaultCodeVerifier;
import dev.samstevens.totp.code.HashingAlgorithm;
import dev.samstevens.totp.exceptions.QrGenerationException;
import dev.samstevens.totp.qr.QrData;
import dev.samstevens.totp.qr.QrGenerator;
import dev.samstevens.totp.qr.ZxingPngQrGenerator;
import dev.samstevens.totp.secret.DefaultSecretGenerator;
import dev.samstevens.totp.time.SystemTimeProvider;
import dev.samstevens.totp.time.TimeProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static dev.samstevens.totp.util.Utils.getDataUriForImage;
/**
 * Ein Service, der Methoden zur Verwaltung der Zwei-Faktor-Authentifizierung (2FA) bereitstellt.
 */
@Service
@Slf4j
public class TwoFactorAuthenticationService {

    /**
     * Generiert ein neues Geheimnis für die 2FA.
     *
     * @return Das generierte Geheimnis als Zeichenfolge.
     */
    public String generateNewSecret() {
        return new DefaultSecretGenerator().generate();
    }

    /**
     * Generiert die URI für ein QR-Code-Bild, das für die 2FA-Authentifizierung verwendet werden kann.
     *
     * @param secret Das Geheimnis, das in den QR-Code eingebettet werden soll.
     * @return Die Daten-URI für das QR-Code-Bild.
     */

    public String generateQrCodeImageUri(String secret) {
        QrData data = new QrData.Builder()
                .label(" Coding 2FA ")
                .secret(secret)
                .issuer("Coding")
                .algorithm(HashingAlgorithm.SHA1)
                .digits(6)
                .period(40)
                .build();

        QrGenerator generator = new ZxingPngQrGenerator();
        byte[] imageData = new byte[0];
        try {
            imageData = generator.generate(data);
        } catch (QrGenerationException e) {
            e.printStackTrace();
            log.error("Error while generating QR-CODE");
        }

        return getDataUriForImage(imageData, generator.getImageMimeType());
    }

    /**
     * Überprüft, ob der eingegebene Einmalpasswort-Code (OTP) gültig ist.
     *
     * @param secret Das Geheimnis, das zur Generierung des OTP verwendet wurde.
     * @param code Der eingegebene OTP-Code zur Überprüfung.
     * @return true, wenn der OTP-Code gültig ist, andernfalls false.
     */

    public boolean isOtpValid(String secret, String code) {
        TimeProvider timeProvider = new SystemTimeProvider();
        CodeGenerator codeGenerator = new DefaultCodeGenerator();
        CodeVerifier verifier = new DefaultCodeVerifier(codeGenerator, timeProvider);
        return verifier.isValidCode(secret, code);
    }
    /**
     * Überprüft, ob der eingegebene Einmalpasswort-Code (OTP) ungültig ist.
     *
     * @param secret Das Geheimnis, das zur Generierung des OTP verwendet wurde.
     * @param code Der eingegebene OTP-Code zur Überprüfung.
     * @return true, wenn der OTP-Code ungültig ist, andernfalls false.
     */
    public boolean isOtpNotValid(String secret, String code) {
        return !this.isOtpValid(secret, code);
    }
}
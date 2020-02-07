package postoffice;

import com.kozachuk.homework.postoffice.PostOffice;
import com.kozachuk.homework.postoffice.dto.PackageBox;
import org.junit.Assert;
import org.junit.Test;

public class PostOfficeTest {
    private PostOffice office = new PostOffice();

    @Test
    public void shouldAnswerWithFalse() {
        PackageBox box        = new PackageBox(1, 1, 1);
        PackageBox packageBox = new PackageBox(1, 1, 1);
        Assert.assertFalse(office.validateSize(box, packageBox));
    }

    @Test
    public void shouldAnswerWithFalse_packageBoxIsSmaller() {
        PackageBox box        = new PackageBox(0.5, 1, 1);
        PackageBox packageBox = new PackageBox(1, 1, 1);
        Assert.assertFalse(office.validateSize(box, packageBox));
    }

    @Test
    public void shouldAnswerWithTrue_boxIsBigger() {
        PackageBox box        = new PackageBox(2, 2, 2);
        PackageBox packageBox = new PackageBox(1, 1, 1);
        Assert.assertTrue(office.validateSize(box, packageBox));
    }

    @Test
    public void shouldAnswerWithFalse_boxIsTheSame_byWidth() {
        PackageBox box        = new PackageBox(2, 3, 4);
        PackageBox packageBox = new PackageBox(3.5, 3, 1);
        Assert.assertFalse(office.validateSize(box, packageBox));
    }

    @Test
    public void shouldAnswerWithFalse_boxIsTheSame() {
        PackageBox box        = new PackageBox(2, 3, 4);
        PackageBox packageBox = new PackageBox(4, 3, 3);
        Assert.assertFalse(office.validateSize(box, packageBox));
    }

    @Test
    public void shouldAnswerWithFalse_boxIsBiggerByWidth() {
        PackageBox box        = new PackageBox(2, 5, 4);
        PackageBox packageBox = new PackageBox(4, 3, 2);
        Assert.assertFalse(office.validateSize(box, packageBox));
    }

    @Test
    public void packageIsSmaller() {
        PackageBox box        = new PackageBox(5, 4, 3);
        PackageBox packageBox = new PackageBox(2, 3, 4);
        Assert.assertTrue(office.validateSize(box, packageBox));
    }

    @Test(expected = NullPointerException.class)
    public void boxIsNull_exception_NPE() {
        PackageBox packageBox = new PackageBox(3, 2, 1);
        office.validateSize(null, packageBox);
    }

    @Test(expected = NullPointerException.class)
    public void pacakgeIsNull_exception_NPE() {
        PackageBox box = new PackageBox(3, 2, 1);
        office.validateSize(box, null);
    }
}

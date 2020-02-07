package postoffice;

import com.kozachuk.homework.postoffice.PostOffice;
import com.kozachuk.homework.postoffice.dto.PackageBox;
import org.junit.Assert;
import org.junit.Test;

public class PostOfficeTest {
    private PostOffice office = new PostOffice();

    @Test
    public void shouldAnswerWithFalse() {
        PackageBox box = PackageBox.getBuilder().length(1).width(1).depth(1).build();
        PackageBox packageBox = PackageBox.getBuilder().length(1).width(1).depth(1).build();

        Assert.assertFalse(office.validateSize(box, packageBox));
    }

    @Test
    public void shouldAnswerWithFalse_packageBoxIsSmaller() {
        PackageBox box = PackageBox.getBuilder().length(0.5).width(1).depth(1).build();
        PackageBox packageBox = PackageBox.getBuilder().length(1).width(1).depth(1).build();

        Assert.assertFalse(office.validateSize(box, packageBox));
    }

    @Test
    public void shouldAnswerWithTrue_boxIsBigger() {
        PackageBox box = PackageBox.getBuilder().length(2).width(2).depth(2).build();
        PackageBox packageBox = PackageBox.getBuilder().length(1).width(1).depth(1).build();

        Assert.assertTrue(office.validateSize(box, packageBox));
    }

    @Test
    public void shouldAnswerWithFalse_boxIsTheSame_byWidth() {
        PackageBox box        = PackageBox.getBuilder().length(2).width(3).depth(4).build();
        PackageBox packageBox = PackageBox.getBuilder().length(3.5).width(3).depth(1).build();

        Assert.assertFalse(office.validateSize(box, packageBox));
    }

    @Test
    public void shouldAnswerWithFalse_boxIsTheSame() {
        PackageBox box        = PackageBox.getBuilder().length(2).width(3).depth(4).build();
        PackageBox packageBox = PackageBox.getBuilder().length(4).width(3).depth(3).build();

        Assert.assertFalse(office.validateSize(box, packageBox));
    }

    @Test
    public void shouldAnswerWithFalse_boxIsTheSame_2() {
        PackageBox box        = PackageBox.getBuilder().length(1).width(2).depth(4).build();
        PackageBox packageBox = PackageBox.getBuilder().length(1).width(2).depth(2).build();

        Assert.assertFalse(office.validateSize(box, packageBox));
    }

    @Test
    public void shouldAnswerWithFalse_boxIsBiggerByWidth() {
        PackageBox box        = PackageBox.getBuilder().length(2).width(4).depth(4).build();
        PackageBox packageBox = PackageBox.getBuilder().length(4).width(3).depth(2).build();

        Assert.assertFalse(office.validateSize(box, packageBox));
    }

    @Test
    public void packageIsSmaller() {
        PackageBox box        = PackageBox.getBuilder().length(5).width(4).depth(3).build();
        PackageBox packageBox = PackageBox.getBuilder().length(2).width(3).depth(4).build();

        Assert.assertTrue(office.validateSize(box, packageBox));
    }

    @Test(expected = NullPointerException.class)
    public void boxIsNull_exception_NPE() {
        PackageBox packageBox = PackageBox.getBuilder().length(2).width(3).depth(4).build();
        office.validateSize(null, packageBox);
    }

    @Test(expected = NullPointerException.class)
    public void pacakgeIsNull_exception_NPE() {
        PackageBox box = PackageBox.getBuilder().length(5).width(4).depth(3).build();
        office.validateSize(box, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exception_iae_length_0() {
        PackageBox.getBuilder().length(0).width(1).depth(1).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void exception_iae_width_0() {
        PackageBox.getBuilder().length(1).width(0).depth(1).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void exception_iae_depth_0() {
        PackageBox.getBuilder().length(1).width(1).depth(0).build();
    }

    @Test
    public void packageIsBuilt() {
        PackageBox box = PackageBox.getBuilder().length(1).width(2).depth(3).build();
        Assert.assertEquals(1, box.getLength(), 0);
        Assert.assertEquals(2, box.getWidth(), 0);
        Assert.assertEquals(3, box.getDepth(), 0);
    }
}

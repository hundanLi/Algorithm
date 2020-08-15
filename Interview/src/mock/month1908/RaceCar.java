package mock.month1908;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-26 11:10
 **/
public class RaceCar {
    public int racecar(int target) {
        int num = 0;
        int speed = 1;
        int position = 0;
        while (position != target) {
            while (position < target) {
                position += speed;
                speed *= 2;
                num++;
            }
            if (position == target) {
                break;
            }
            speed = -1;
            num++;
            while (position > target) {
                position += speed;
                speed *= 2;
                num++;
            }
            if (position == target) {
                break;
            }
            speed = 1;
            num++;
        }
        return num;
    }
}

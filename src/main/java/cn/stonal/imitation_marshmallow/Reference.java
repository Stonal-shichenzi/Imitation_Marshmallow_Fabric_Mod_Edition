package cn.stonal.imitation_marshmallow;

public class Reference {
    public static int random_integer(int floor, int ceil)
    {
        return random_integer(floor, ceil, false);
    }
    public static int random_integer(int floor, int ceil, boolean report_logs)
    {
        if(floor > ceil)
            return random_integer(ceil, floor);
        if(floor == ceil)
            return floor;
        if(floor < 0)
            return random_integer(0, ceil - floor) + floor;
        double random_value = Math.random();
        int random = (int)(random_value * (ceil - floor + 1) + floor);
        if(report_logs)
            ImitationMarshmallow.LOGGER.info("Method random_integer in cn.stonal.imitation_marshmallow.Reference returned the value {}", random);
        return random;
    }
    public static int to_integer(boolean value)
    {
        return value ? 1 : 0;
    }
}

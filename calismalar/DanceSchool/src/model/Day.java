package model;

import java.util.Arrays;
import java.util.Optional;

public enum Day {
        MONDAY(0),TUESDAY(1),WEDNESDAY(2),THURSDAY(3),FRIDAY(4),SATURDAY(5),SUNDAY(6);

        public final int id;

        private Day(int id){
                this.id = id;
        }

        public static Optional<Day> valueOf(int id) {
                return Arrays.stream(Day.values())
                        .filter(day -> day.id == id)
                        .findFirst();
        }
}

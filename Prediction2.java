import java.time.LocalTime; import java.util.ArrayList;

import java.util.List;
class 
  TimeTableEntry { String teacher; String room;
  String date;
  LocalTime startTime;
  LocalTime endTime;
  TimeTableEntry(String teacher, String room, String date, String start, String end) { this.teacher = teacher;
       this.room = room; this.date = date;
       this.startTime = LocalTime.parse(start); this.endTime = LocalTime.parse(end);
  }
}
public class ConflictPrediction {
   public static void main(String[] args) {
// Existing timetable records
      List<TimeTableEntry> timetable = new ArrayList<>();
      timetable.add(new TimeTableEntry("A. Sharma", "R102", "2025-11-06", "09:30", "10:30"));
      timetable.add(new TimeTableEntry("B. Kumar", "R103", "2025-11-06", "10:00", "11:00"));

// New entry to check
      TimeTableEntry newEntry = new TimeTableEntry("A. Sharma", "R102", "2025-11-06", "10:00", "11:00");
      boolean conflictFound = false;
// Checking for conflicts
      for (TimeTableEntry entry : timetable) {
           boolean sameDate = entry.date.equals(newEntry.date);
           boolean sameTeacher = entry.teacher.equals(newEntry.teacher); boolean sameRoom = entry.room.equals(newEntry.room);
           boolean timeOverlap = newEntry.startTime.isBefore(entry.endTime) && newEntry.endTime.isAfter(entry.startTime);
           if (sameDate && (sameTeacher || sameRoom) && timeOverlap) { conflictFound = true;
                 System.out.println("⚠ Conflict Detected!");
                System.out.println("Teacher/Room already in use between " + entry.startTime + " and " + entry.endTime);
                break;
          }
     }
     if (!conflictFound) {
         System.out.println("⬛✓ No Conflict Found. Safe to schedule this class.");
     }
   }
}

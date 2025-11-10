boolean conflict = false;
for (TimeTableEntry existingEntry : timetableList) {
  if (existingEntry.getTeacherName().equals(newEntry.getTeacherName()) && existingEntry.getDate().equals(newEntry.getDate())
      && newEntry.getStartTime().isBefore(existingEntry.getEndTime()) && newEntry.getEndTime().isAfter(existingEntry.getStartTime())) {
     conflict = true; break;
  }
}
  if (conflict) {
      System.out.println("⚠ Conflict Detected: Teacher already scheduled at this time.");
} else {
      System.out.println("⬛✓ No Conflict Found. Safe to schedule.");
}
---

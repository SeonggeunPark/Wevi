import { useState, useRef } from "react";
import Calendar from "react-calendar";
import "react-calendar/dist/Calendar.css";
import TopNavigationBar from "../components/Navigators/TopNavigationBar";
import scheduleData from "../scheduleData.js";
import CardCalendar from "../components/Cards/CardCalendar.jsx";
import BottomNavigationBar from "../components/Navigators/BottomNavigationBar.jsx";
import "../pages/react-calendar.css"

export default function CalendarPage() {
  const [selectedDate, setSelectedDate] = useState(new Date());
  const scheduleRefs = useRef({}); // 날짜별 첫 번째 일정의 ref 저장

  // 날짜 클릭 시 해당 날짜의 첫 번째 일정으로 이동
  const handleDateClick = (date) => {
    setSelectedDate(date);
    const formattedDate = date.toISOString().split("T")[0];

    // 해당 날짜의 첫 번째 일정으로 스크롤
    if (scheduleRefs.current[formattedDate]?.length > 0) {
      scheduleRefs.current[formattedDate][0].scrollIntoView({
        behavior: "smooth",
        block: "start",
      });
    }
  };

  return (
    <>
      <TopNavigationBar />
      <div className="min-h-screen  bg-gray-100 p-4">
        {/* 📅 캘린더 */}
        <div className="bg-white rounded-lg shadow-md p-4 mb-4">
          <Calendar 
            style={{
              width: "100%",
              maxWidth: "1024px",
              margin: "0 auto",
              borderRadius: "8px",
              boxShadow: "0 4px 6px rgba(0, 0, 0, 0.1)",
            }}
            className="custom-calendar"
            onChange={handleDateClick}
            value={selectedDate}
            tileClassName={({ date, view }) =>
              view === "month" &&
              scheduleData.some(
                (s) => s.date === date.toISOString().split("T")[0]
              )
                ? "highlight-date"
                : null
            }
          />
        </div>

        {/* 📝 일정 리스트 */}
        <div className="space-y-4">
          {scheduleData.map((schedule, index) => (
            <CardCalendar
              key={index}
              schedule={schedule}
              ref={(el) => {
                if (el) {
                  if (!scheduleRefs.current[schedule.date]) {
                    scheduleRefs.current[schedule.date] = [];
                  }
                  scheduleRefs.current[schedule.date].push(el);
                }
              }}
            />
          ))}
        </div>
      </div>
      <BottomNavigationBar />
    </>
  );
}

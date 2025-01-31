import { forwardRef } from "react";

const CardCalendar = forwardRef(({ schedule }, ref) => {
  return (
    <div
      ref={ref}
      className="bg-white rounded-lg shadow-md p-4 flex items-center space-x-4"
    >
      <img
        src={schedule.image}
        alt={schedule.title}
        className="h-16 w-16 rounded-lg object-cover"
      />
      <div className="flex-1">
        <h3 className="text-lg font-bold">{schedule.title}</h3>
        <p className="text-gray-500">{schedule.location}</p>
        <p className="text-gray-700 font-semibold">{schedule.time}</p>
      </div>
      <button className="text-gray-500 hover:text-gray-700">➜</button>
    </div>
  );
});
CardCalendar.displayName = "CardCalendar";

export default CardCalendar;

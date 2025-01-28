import React from "react";

function BottomNavigationBar() {
  return (

      <nav className="bg-pink-200 fixed bottom-0 w-full flex justify-around py-3 shadow-md">
        {/* 홈 */}
          <div className="absolute bottom-16 bg-blue-200 text-center w-full">
    명암선
  </div>
        <div className="flex flex-1 flex-col items-center">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            className="h-6 w-6 mb-1"
            fill="none"
            viewBox="0 0 24 24"
            stroke="currentColor"
          >
            <path
              strokeLinecap="round"
              strokeLinejoin="round"
              strokeWidth={2}
              d="M3 9.75 L12 4.5 l9 5.25V18a2.25 2.25 0 01-2.25 2.25H5.25A2.25 2.25 0 013 18V9.75z"
            />
          </svg>
          <span className="text-sm">홈</span>
        </div>

        {/* 검색 */}
        <div className="flex flex-1 flex-col items-center">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            className="h-6 w-6 mb-1"
            fill="none"
            viewBox="0 0 24 24"
            stroke="currentColor"
          >
            <path
              strokeLinecap="round"
              strokeLinejoin="round"
              strokeWidth={2}
              d="M21 21l-4.35-4.35M10.5 18a7.5 7.5 0 100-15 7.5 7.5 0 000 15z"
            />
          </svg>
          <span className="text-sm">검색</span>
        </div>

        {/* 일정 */}
        <div className="flex flex-1 flex-col items-center">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            className="h-6 w-6 mb-1"
            fill="none"
            viewBox="0 0 24 24"
            stroke="currentColor"
          >
            <path
              strokeLinecap="round"
              strokeLinejoin="round"
              strokeWidth={2}
              d="M8 7V3m8 4V3m-9 9h10m-11 5h12m-5 4h-2M9 3h6"
            />
          </svg>
          <span className="text-sm">일정</span>
        </div>

        {/* 진행도 */}
        <div className="flex flex-1 flex-col items-center">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            className="h-6 w-6 mb-1"
            fill="none"
            viewBox="0 0 24 24"
            stroke="currentColor"
          >
            <path
              strokeLinecap="round"
              strokeLinejoin="round"
              strokeWidth={2}
              d="M4 6h16M4 12h16m-7 6h7"
            />
          </svg>
          <span className="text-sm">진행도</span>
        </div>

        {/* 마이페이지 */}
        <div className="flex flex-1 flex-col items-center">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            className="h-6 w-6 mb-1"
            fill="none"
            viewBox="0 0 24 24"
            stroke="currentColor"
          >
            <path
              strokeLinecap="round"
              strokeLinejoin="round"
              strokeWidth={2}
              d="M12 12c2.21 0 4-1.79 4-4s-1.79-4-4-4-4 1.79-4 4 1.79 4 4 4z"
            />
          </svg>
          <span className="text-sm">마이페이지</span>
        </div>
      </nav>
  );
}

export default BottomNavigationBar;

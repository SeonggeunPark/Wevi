import TopNavigationBar from "../components/Navigators/TopNavigationBar";
import BottomNavigationBar from "../components/Navigators/BottomNavigationBar";
import potatooriginal from "../assets/potatooriginal.png";

import { useState } from "react";

export default function HomePage() {
  // 말풍선 내용 상태 관리
  const [speechText, setSpeechText] = useState("안녕하세요");

  // 말풍선 내용 변경 핸들러
  const handleInputChange = (event) => {
    setSpeechText(event.target.value); // 입력값으로 말풍선 업데이트
  };

  return (
    <>
      <TopNavigationBar />
      <main className="flex flex-col w-screen items-center justify-center overflow-hidden h-[calc(100vh-144px)] bg-[#609966]">
        {/* 가운데 사진 */}
        <div className="relative">
          <img
            src={potatooriginal} // 감자 이미지 경로 설정
            alt="Potato"
            className="w-auto h-auto" // 높이 고정
          />
          {/* 말풍선 */}
          <div className="font-pretendard absolute top-15 left-1/2 -translate-x-1/2 -translate-y-full bg-white p-4 rounded-lg shadow-md text-center text-gray-800 w-[300px] max-w-auto max-h-30 overflow-y-auto whitespace-normal">
            {speechText}
          </div>
        </div>

        {/* 입력창 */}
        <div className="mt-6">
          <input
            type="text"
            value={speechText}
            onChange={handleInputChange}
            placeholder="말풍선 내용을 입력하세요"
            className="w-72 p-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-pink-400"
          />
        </div>
      </main>
      <BottomNavigationBar />
    </>
  );
}

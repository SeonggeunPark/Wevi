import React from "react";

function SearchBar() {
  return (
    <section className="bg-white shadow-md p-4">
      <input
        type="text"
        placeholder="AI 검색"
        className="w-full bg-purple-100 p-2 rounded-md mb-4"
      />
      {/* 버튼 클릭에 따라서 하단 호텔/리조트 등 옵션 바뀌게 */}
      <div className="flex justify-between text-sm text-black-500 mb-4">
        <button className="cursor-pointer flex-grow text-center py-2 bg-[#900604] rounded mx-2">웨딩홀</button>
        <button className="cursor-pointer flex-grow text-center py-2 bg-green-200 rounded mx-2">드레스</button>
        <button className="cursor-pointer flex-grow text-center py-2 bg-green-200 rounded mx-2">스튜디오</button>
        <button className="cursor-pointer flex-grow text-center py-2 bg-black rounded mx-2">메이크업</button>
      </div>
      <input
        type="text"
        placeholder="검색"
        className="w-full bg-white-100 p-2 rounded-md mb-4"
      />
      <div className="grid grid-cols-3 gap-4 mb-4">
        <select className="bg-gray-100 p-2 rounded-md">
          <option>호텔/리조트</option>
          <option>컨벤션</option>
          <option>하우스</option>
        </select>
        <input
          type="text"
          placeholder="지역"
          className="bg-gray-100 p-2 rounded-md"
        />
        <input
          type="date"
          className="bg-gray-100 p-2 rounded-md"
          placeholder="날짜 선택"
        />
      </div>
    </section>
  );
}

export default SearchBar;

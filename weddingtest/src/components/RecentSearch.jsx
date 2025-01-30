import React from "react";

function RecentSearch() {
  const searches = [
    { id: 1, title: "강남 웨딩홀", details: "06.21~06.22 | 1박 성인 2, 아동 0" },
    { id: 2, title: "청담 드레스샵", details: "06.21~06.22 | 1박 성인 2, 아동 0" },
  ];

  return (
    <section className="p-4">
      <h2 className="text-lg font-semibold mb-4">최근 검색</h2>
      <ul>
        {searches.map((search) => (
          <li
            key={search.id}
            className="flex justify-between items-center bg-white p-2 mb-2 rounded-lg shadow-md"
          >
            <div>
              <p className="font-bold">{search.title}</p>
              <p className="text-sm text-gray-500">{search.details}</p>
            </div>
            <button className="text-gray-400">&#10006;</button>
          </li>
        ))}
      </ul>
      <button className="text-sm text-blue-500 mt-2">전체 삭제</button>
    </section>
  );
}

export default RecentSearch;

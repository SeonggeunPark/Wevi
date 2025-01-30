import React from "react";
import example_weddinghall from "../assets/example_weddinghall.png"

function PopularServices() {
  const services = [
    {
      id: 1,
      name: "강남 웨딩홀",
      priceRange: "12,441,000원 ~ 37,128,000원",
      image: example_weddinghall,
    },
    {
      id: 2,
      name: "압구정 스튜디오",
      priceRange: "12,441,000원 ~ 37,128,000원",
      image: example_weddinghall,
    },
  ];

  return (
    <section className="p-4">
      <h2 className="text-lg font-semibold mb-4">지금 사랑받는 웨딩 서비스</h2>
      <div className="grid grid-cols-1 gap-4">
        {services.map((service) => (
          <div
            key={service.id}
            className="bg-white rounded-lg shadow-md overflow-hidden"
          >
            <img src={service.image} alt={service.name} className="w-full h-40 object-cover" />
            <div className="p-4">
              <h3 className="font-bold">{service.name}</h3>
              <p className="text-sm text-gray-500">{service.priceRange}</p>
            </div>
          </div>
        ))}
      </div>
    </section>
  );
}

export default PopularServices;

import { useNavigate, useParams } from "react-router-dom";
import weddinghall_default from "@/assets/weddinghall_default.png";
import dress_default from "@/assets/dress_default.png";
import studio_default from "@/assets/studio_default.png";
import makeup_default from "@/assets/makeup_default.png";

const categoryImages = {
  weddinghall: weddinghall_default,
  dress: dress_default,
  studio: studio_default,
  makeup: makeup_default,
};

export default function Card({ data }) {
  const navigate = useNavigate();
  const { category } = useParams(); // /search/:category 경로에서 category를 추출
  function handleCardClick(id) {
    navigate(`/searchDetail/${category}?id=${id}`);
  }
  // console.log(data);
  return (
    <div
      key={data.id}
      className="bg-white rounded-lg shadow-md overflow-hidden cursor-pointer"
      onClick={() => handleCardClick(data.id)}
    >
      <img
        src={
          data.imageUrl === "default" ? categoryImages[category] : data.imageUrl
        }
        alt={data.vendorName}
        className="w-full h-[20vh] object-cover overflow-x-auto"
      />
      <div className="pt-4 pl-4 pr-4">
        <h3 className="font-bold">{data.vendorName}</h3>
        <p className="text-sm text-gray-500">{data.doName}</p>
      </div>
      <div className="p-4">
        <h3 className="font-bold text-md text-right">
          {data.minPrice.toLocaleString()}원 ~
        </h3>
      </div>
    </div>
  );
}

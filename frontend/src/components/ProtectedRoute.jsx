import { Navigate, Outlet, useLocation } from "react-router-dom";
import { useRecoilValue } from "recoil";
import { userState } from "@/atoms/userState";

const ProtectedRoute = () => {
  const user = useRecoilValue(userState);
  const location = useLocation();
  console.log(user);
  if (!user.default) {
    return <Navigate to="/login" state={{ from: location }} replace />;
  }

  return <Outlet />;
};

export default ProtectedRoute;

import { createBrowserRouter, RouterProvider } from "react-router-dom";
import "./App.css";
import Loginpage from "./pages/loginpage";
import SignUpPage from "./pages/signuppage";
import SignUpDetailPage from "./pages/signupdetailpage";
import HomePage from "./pages/homepage";
import AlarmPage from "./pages/alarmpage";
import CalendarPage from "./pages/calendarpage";
import HamburgerPage from "./pages/hamburgerpage";
import MyPage from "./pages/mypage";
import ProgressPage from "./pages/progresspage";
import SearchPage from "./pages/searchpage";
import AiPlannerPage from "./pages/aiplannerpage";
import ProtectedRoute from "./components/ProtectedRoute";
import { RecoilRoot } from "recoil";

const router = createBrowserRouter([
  { path: "/login", element: <Loginpage /> },
  { path: "/signup", element: <SignUpPage /> },
  { path: "/signupdetail", element: <SignUpDetailPage /> },
  {
    element: <ProtectedRoute />,
    children: [
      { path: "/", element: <HomePage /> },
      { path: "/alarm", element: <AlarmPage /> },
      { path: "/calendar", element: <CalendarPage /> },
      { path: "/hamburger", element: <HamburgerPage /> },
      { path: "/mypage", element: <MyPage /> },
      { path: "/progress", element: <ProgressPage /> },
      { path: "/search", element: <SearchPage /> },
      { path: "/aiplanner", element: <AiPlannerPage /> },
    ],
  },
]);

function App() {
  return (
    <RecoilRoot>
      <RouterProvider router={router} />
    </RecoilRoot>
  );
}

export default App;

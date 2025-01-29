import { useState } from 'react'
import {createBrowserRouter, RouterProvider} from 'react-router-dom'
import './App.css'
import Loginpage from './pages/loginpage'
import SignUpPage from './pages/signuppage'
import SignUpDetailPage from './pages/signupdetailpage'

const router = createBrowserRouter([
  {path: '/login', element: <Loginpage/>},
  {path: '/signup', element: <SignUpPage/>},
  {path: '/signupdetail', element: <SignUpDetailPage/>},
])

function App() {

  return (
    <>
      <RouterProvider router={router}/>
    </>
  )
}

export default App



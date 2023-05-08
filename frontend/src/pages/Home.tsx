import React from 'react';
import './Home.css';
import '../assets/Global.css';

import { RegisterModal } from '../features/register/components/RegisterModal/RegisterModal';

export const Home:React.FC = () => {
  return (
    <div className='home-container bg-color'>
       <RegisterModal/>
          
    </div>
  )
} 
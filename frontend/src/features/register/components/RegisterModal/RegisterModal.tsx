import React from 'react'
import { Modal }  from '../../../../components/Modal/Modal'
import './RegisterModal.css'
import { RegisterStepCounter } from '../RegisterStepCounter/RegisterStepCounter'

export const RegisterModal:React.FC = () => {
  return (
    <Modal>
      <div className='register-container'>
        <RegisterStepCounter step={2}/>
            </div>
    </Modal>
  )
}

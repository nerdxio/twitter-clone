import React from 'react'
import { useState } from 'react'

import { Modal } from '../../../../components/Modal/Modal'
import './RegisterModal.css'
import { RegisterStepCounter } from '../RegisterStepCounter/RegisterStepCounter'

export const RegisterModal: React.FC = () => {

  const [step, setStep] = useState<number>(4);

  const stepButtonClicked = () => {

    step === 1 || step === 4 || step >= 6 ? setStep(step) : setStep(step);

  }

  return (
    <Modal>
      <div className='register-container'>
        <RegisterStepCounter step={step} changeStep={stepButtonClicked} />
      </div>
    </Modal>
  )
}

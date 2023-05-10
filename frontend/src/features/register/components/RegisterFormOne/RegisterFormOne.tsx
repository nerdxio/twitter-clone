import React, { useState, useEffect } from 'react'
import './RegisterFormOne.css'
import { TextInput } from '../../../../components/TextInput/TextInput'

interface FormOneState {
    firstName: string
    lastName: string
    email: string
    dataOfBirth: string
}
export const RegisterFormOne: React.FC = () => {

    const [stepOneState, setStepOneState] = useState<FormOneState>({
        firstName: "",
        lastName: "",
        email: "",
        dataOfBirth: ""
    });

    const updateUser = (e: React.ChangeEvent<HTMLInputElement>): void => {
        setStepOneState({ ...stepOneState, [e.target.name]: e.target.value });
    }

    useEffect(() => {
        console.log("State chang: ", stepOneState);
    }, [stepOneState])

    return (
        <div className='reg-step-one-container'>
            <div className="reg-step-on-content">
                <TextInput name={'firstName'} label={"First"}
                    errorMessage={"Please enter you name"}
                    onChange={updateUser} />

                <TextInput name={'lastName'} label={"Last"}
                    errorMessage={"Please enter you name"}
                    onChange={updateUser} />

                <TextInput name={'email'} label={"Email"}
                    errorMessage={"Please enter a valid Email"}
                    onChange={updateUser} />
            </div>

        </div>
    )
}

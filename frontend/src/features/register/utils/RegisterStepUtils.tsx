import { ClearRounded, ArrowBackRounded } from '@mui/icons-material'


export const displayIcon = (step: number): JSX.Element => {
    switch (step) {

        case 1:
            return <ClearRounded sx={{ fontSize: 25 }} />
        case 2:
            return <ArrowBackRounded sx={{ fontSize: 25 }} />
        case 3:
            return <ArrowBackRounded sx={{ fontSize: 25 }} />
        case 4:
            return <></>
        case 5:
            return <ArrowBackRounded sx={{ fontSize: 25 }} />
        case 6:
            return <></>
        default:
            return <></>
    }
}
export const iconClass = (step: number): string => {
    if (step === 4 || step === 9) {
        return "reg-step-counter-btn-disable";
    }

    return "reg-step-counter-btn";

}
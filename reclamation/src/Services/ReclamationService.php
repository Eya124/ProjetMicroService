<?php

namespace App\Services;

use App\Entity\Reclamation;
use App\Repository\ReclamationRepository;
use Doctrine\ORM\EntityManagerInterface;

class ReclamationService
{
    private $entityManager;
    private $reclamationRepository;

    public function __construct(EntityManagerInterface $entityManager, ReclamationRepository $reclamationRepository)
    {
        $this->entityManager = $entityManager;
        $this->reclamationRepository = $reclamationRepository;
    }

    public function getAllReclamations()
    {
        return $this->entityManager->getRepository(Reclamation::class)->findAll();
    }

    public function findReclamationById(int $id): ?Reclamation
    {
        return $this->entityManager->getRepository(Reclamation::class)->find($id);
    }

    public function createReclamation($sujet, $message, $statut, $userId, $priorite, $departement)
    {
        $reclamation = new Reclamation();
        $reclamation->setSujet($sujet);
        $reclamation->setMessage($message);
        $reclamation->setCreateAt(new \DateTimeImmutable());
        $reclamation->setStatut($statut);
        $reclamation->setUserId($userId);
        $reclamation->setPriorite($priorite);
        $reclamation->setDepartement($departement);

        $this->entityManager->persist($reclamation);
        $this->entityManager->flush();

        return $reclamation;
    }

    public function updateReclamation($reclamationId, $newsujet, $newMessage, $newstatut, $userId, $newpriorite, $newdepartement)
    {
        $reclamation = $this->entityManager->getRepository(Reclamation::class)->find($reclamationId);

        if (!$reclamation) {
            throw new \Exception('Reclamation not found');
        }

        $reclamation->setSujet($newsujet);
        $reclamation->setMessage($newMessage);
        $reclamation->setStatut($newstatut);
        $reclamation->setUserId($userId);
        $reclamation->setPriorite($newpriorite);
        $reclamation->setDepartement($newdepartement);

        $this->entityManager->flush();

        return $reclamation;
    }

    public function deleteReclamation($reclamationId)
    {
        $reclamation = $this->entityManager->getRepository(Reclamation::class)->find($reclamationId);

        if (!$reclamation) {
            throw new \Exception('Reclamation not found');
        }

        $this->entityManager->remove($reclamation);
        $this->entityManager->flush();
    }

}